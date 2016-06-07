package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub06_threadsAndExceptions;

/* # 7.1 # thread, which throws an exception */

public class ExceptThread extends Thread {
    @Override
    public void run() {
        boolean flag = true;
        if (flag) {
            throw new RuntimeException();
        }
        System.out.println("end of ExceptThread"); // unreachable statement
    }
}
