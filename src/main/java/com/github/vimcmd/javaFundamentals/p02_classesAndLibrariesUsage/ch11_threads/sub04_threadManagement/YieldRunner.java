package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub04_threadManagement;

/* # 5 # delay thread */

public class YieldRunner {
    public static void main(String[] args) {
        new Thread() { // anonymous class
            @Override
            public void run() {
                System.out.println("Starting thread 1");
                Thread.yield(); // yield time for other threads (for ex.: if current thread priority is max, but it waits some data)
                System.out.println("Finishing thread 1");
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                System.out.println("Start thread 2");
                System.out.println("Finish thread 2");
            }
        }.start();
    }
}
