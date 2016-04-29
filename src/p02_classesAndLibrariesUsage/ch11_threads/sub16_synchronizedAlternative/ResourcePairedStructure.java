package p02_classesAndLibrariesUsage.ch11_threads.sub16_synchronizedAlternative;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* # 35 # resources can be added/deleted only by pairs in one thread.
Other thread must wait until lock owner complete its work */

public class ResourcePairedStructure {
    private Deque<String> list = new LinkedList<>();
    private Lock lock = new ReentrantLock();
    private Condition isFree = lock.newCondition(); // lock management

    public void adding(String str, int i) {
        // more flexible analogue of synchronized block
        try {
            lock.lock(); // wait() analogue
            list.add(i + "<" + str);
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(50));
            list.add(str + ">" + i);
            isFree.signal(); // notify() analogue
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public String deleting() {
        lock.lock();
        String s = list.poll();
        s += list.poll();
        isFree.signal();
        lock.unlock();
        return s;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
