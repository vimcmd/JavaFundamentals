package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub05_threadDaemons;

/* # 6 # starting and executing daemon thread */

public class DaemonRunner {
    public static void main(String[] args) {
        SimpleThread normalThread = new SimpleThread();
        SimpleThread daemonThread = new SimpleThread();

        daemonThread.setDaemon(true);

        daemonThread.start(); // works in background (primary thread maintenance) and not necessary for program
        normalThread.start();
        System.out.println("Last command in main thread"); // closing main thread and exit app, despite daemon still works
    }
}
