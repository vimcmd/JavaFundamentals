package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub18_phasers;

import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* # 45 # storage (collection) */

public class Storage implements Iterable<Item> {

    public static final int DEFAULT_STORAGE_CAPACITY = 20;
    private Queue<Item> goods = null;

    public Storage() {
        goods = new LinkedBlockingQueue<Item>(DEFAULT_STORAGE_CAPACITY);
    }

    public Storage(int capacity) {
        goods = new LinkedBlockingQueue<Item>(capacity);
    }

    public static Storage createStorage(int capacity) {
        return new Storage(capacity);
    }

    public static Storage createStorage(int capacity, List<Item> list) {
        Storage storage = new Storage(capacity);
        storage.goods.addAll(list);
        return storage;
    }

    public Item getGood() {
        return goods.poll();
    }

    public void addGood(Item good) {
        goods.add(good);
    }

    @Override
    public Iterator<Item> iterator() {
        return goods.iterator();
    }
}
