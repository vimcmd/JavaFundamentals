package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub06_threadsAndExceptions;

/* # 8 # generate exception in main thread */

public class ExceptionMainThreadDemo {
    public static void main(String[] args) {
        new SimpleThread().start();
        System.out.println("end of main thread with an exception");
        throw new RuntimeException();
        // other thread will continue to work
    }
}
