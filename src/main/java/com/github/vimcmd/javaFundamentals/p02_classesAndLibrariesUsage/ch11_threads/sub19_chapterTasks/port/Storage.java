package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub19_chapterTasks.port;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Storage implements Iterable<Container> {

    private List<Container> storage = null;
    private int capacity;
    private Lock lock;
    private Condition isFree;

    public Storage(int capacity) {
        this.capacity = capacity;
        lock = new ReentrantLock(true); // fair ordering policy
        isFree = lock.newCondition();
        storage = new ArrayList<Container>(capacity);
        initStorage(new Random().nextInt(capacity));
    }

    public void put(Container container, long timeWaitMillis) {
        try {
            lock.lock();
            if (storage.size() < capacity) {
                storage.add(container);
            } else {
                System.out.println("Waiting for loading container #" + container.getContainerId());
                isFree.await();
            }
            TimeUnit.MILLISECONDS.sleep(timeWaitMillis);
            isFree.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Container pickRandom(long timeWaitMillis) {
        Container container = null;
        try {
            if (storage.isEmpty()) {
                System.out.println("Port storage is empty");
                return null;
            }
            lock.lock();
            while (container == null) {
                container = storage.remove(new Random().nextInt(storage.size())); // get random container
            }
            TimeUnit.MILLISECONDS.sleep(timeWaitMillis);
            isFree.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return container;
    }

    @Override
    public Iterator<Container> iterator() {
        return storage.iterator();
    }

    public boolean isEmpty() {
        return storage.isEmpty();
    }

    public void initStorage(int fillCount) {
        if (fillCount > this.capacity) {
            fillCount = this.capacity;
        }
        for(int i = 0; i < fillCount; i++) {
            Container container = new Container(i + 1000); // 1000 appended for obvious output on console
            put(container, 0);
        }
    }
}
