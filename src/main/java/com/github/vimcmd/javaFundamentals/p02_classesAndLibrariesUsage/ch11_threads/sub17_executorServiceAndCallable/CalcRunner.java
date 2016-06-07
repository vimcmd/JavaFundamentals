package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub17_executorServiceAndCallable;

import java.util.concurrent.*;

/* # 39 # start threads and extracting result of their execution */

public class CalcRunner {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor(); // only one thread will be executed
        Future<Number> future = es.submit(new CalcCallable());
        es.shutdown(); // previously submitted tasks are executed, but no new tasks will be accepted
        try {
            while (!future.isDone()) {
                System.out.println("wait for value...");
                TimeUnit.MILLISECONDS.sleep(2);
            }
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
