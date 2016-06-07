package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub07_atomicTypesAndVolatileModifier;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/* # 9 # class with atomic field type */

public class Market extends Thread {
    private AtomicLong index; // provides non-blocking synchronisation (extending volatile notation for values, fields, array elements)

    public Market(AtomicLong index) {
        this.index = index;
    }

    public AtomicLong getIndex() {
        return index;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            while (true) {
                index.addAndGet(random.nextInt(10));
                System.err.println("market updated (1/2)");
                Thread.sleep(random.nextInt(500));

                index.addAndGet(-1 * random.nextInt(10));
                System.err.println("market updated (2/2)");
                Thread.sleep(random.nextInt(500));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
