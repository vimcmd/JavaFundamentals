package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub06_threadsAndExceptions;

/* # 7 # generate exception in created thread */

public class ExceptionThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        ExceptThread exceptThread = new ExceptThread();
        exceptThread.start();
        Thread.sleep(1_000);
        System.out.println("main thread finished");
    }
}
