package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub04_singleton.s04_reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * To ensure synchronization without initializing the instance
 * in a static field, you can use the class ReentrantLock.
 * This solution is somewhat more productive than synchronized.
 */
public class SingletonLockImpl {

    private static SingletonLockImpl instance = null;
    private static ReentrantLock lock = new ReentrantLock();

    private SingletonLockImpl() {
    }

    public static SingletonLockImpl getInstance() {
        lock.lock();

        try {
            if (instance == null) {
                instance = new SingletonLockImpl();
            }
        } finally {
            lock.unlock();
        }

        return instance;
    }
}
