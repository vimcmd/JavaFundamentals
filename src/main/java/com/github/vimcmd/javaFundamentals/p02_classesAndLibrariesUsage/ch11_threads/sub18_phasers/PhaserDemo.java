package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub18_phasers;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Phaser;

/* # 46 # */

public class PhaserDemo {
    public static void main(String[] args) {
        // create collection of goods
        Item[] goods = new Item[20];
        for(int i = 0; i < 20; i++) {
            goods[i] = new Item(i + 1);
        }

        List<Item> goodsList = Arrays.asList(goods);

        // create warehouse from which the goods taken
        Storage storageA = Storage.createStorage(goodsList.size(), goodsList);

        // create warehouse to which the goods delivered
        Storage storageB = Storage.createStorage(goodsList.size());

        Phaser phaser = new Phaser();
        phaser.register();

        int currentPhase;

        printGoodsToConsole("Goods on warehouse A: ", storageA);
        printGoodsToConsole("Goods on warehouse B: ", storageB);

        // create convoy of trucks
        for(int i = 1; i < 4; i++) {
            new Thread(new Truck(phaser, i + "", 2 + new Random().nextInt(10), storageA, storageB)).start();
        }

        // loading trucks synchronization
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Convoy loading complete. Phase #" + currentPhase + " completed");

        // journey synchronization
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Convoy journey complete. Phase #" + currentPhase + " completed");

        // unloading trucks synchronization
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Convoy unloading complete. Phase #" + currentPhase + " completed");

        phaser.arriveAndDeregister();

        if (phaser.isTerminated()) {
            System.out.println("Phases synchronized and completed");
        }

        printGoodsToConsole("Goods on warehouse A: ", storageA);
        printGoodsToConsole("Goods on warehouse B: ", storageB);
    }

    private static void printGoodsToConsole(String title, Storage storage) {
        System.out.println("\n" + title);
        for ( Item item : storage ) {
            System.out.print("#" + item.getRegistrationNumber() + " ");
        }
        System.out.println();
    }
}
