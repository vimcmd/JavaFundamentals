package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub04_singleton.s05_semaphore;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 * If singleton pattern implies restriction on number of references more than one,
 * it is convenient initialize via semaphore.
 * <br>
 * This solution - slowest, but its advantage in a custom number of references.
 */
public class SingletonSemaphore {

    private static final int MAX_AVAILABLE = 10; // instances limit
    private static Semaphore semaphore = new Semaphore(MAX_AVAILABLE, true);
    private static ArrayList<SingletonSemaphore> instances = new ArrayList<>(MAX_AVAILABLE);

    private SingletonSemaphore() {
    }

    private static SingletonSemaphore getInstance(int index) throws SingletonException {
        if (index >= 0 && index < instances.size()) {
            return instances.get(index);
        }
        if (semaphore.tryAcquire()) { // decrease semaphore value
            SingletonSemaphore temp = new SingletonSemaphore();
            instances.add(temp);
            return temp;
        }
        throw new SingletonException("singleton instances limit is exceeded");
    }

}
