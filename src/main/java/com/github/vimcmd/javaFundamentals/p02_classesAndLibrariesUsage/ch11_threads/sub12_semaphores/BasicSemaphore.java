package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub12_semaphores;

import java.util.concurrent.Semaphore;

/* # 17 # basic solution using semaphore */

public class BasicSemaphore {
    public static void main(String[] args) throws InterruptedException {
        final Semaphore semaphore = new Semaphore(5, true);
        System.out.println("Semaphore available permits: " + semaphore.availablePermits());

        for(int i = 0; i < 10; i++) {
            Thread.sleep((int)(Math.random() * 500)); // start threads with delay
            new Thread("thread" + i) {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(getName() + " acquired semaphore");
                        Thread.sleep(3_000); // wait before release semaphore
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                        System.out.println(getName() + " released semaphore");
                    }
                }
            }.start();
        }
    }
}
