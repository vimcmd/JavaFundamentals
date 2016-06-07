package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub15_exchangeLocks;

/* # 34 # start exchanging process */

public class RunExchange {
    public static void main(String[] args) {
        Item g1 = new Item(34, 2200);
        Item g2 = new Item(34, 2100); // try 2500

        new Thread(new Producer("HP", g1)).start();
        new Thread(new Consumer("RetailTrade", g2)).start();
    }
}
