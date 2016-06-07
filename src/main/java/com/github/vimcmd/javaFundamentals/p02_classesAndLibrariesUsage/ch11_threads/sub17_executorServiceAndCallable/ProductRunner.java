package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub17_executorServiceAndCallable;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* # 42 # start threads pool and get data of their work */

public class ProductRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayList<Future<String>> list = new ArrayList<>();
        ExecutorService es = Executors.newFixedThreadPool(3); // three threads will be run at same time

        for(int i = 0; i < 7; i++) { // execute BaseCallable 7 times
            list.add(es.submit(new BaseCallable()));
        }

        es.shutdown();

        for(Future<String> future : list) {
            System.out.println(future.get() + " result fixed");
        }
    }
}
