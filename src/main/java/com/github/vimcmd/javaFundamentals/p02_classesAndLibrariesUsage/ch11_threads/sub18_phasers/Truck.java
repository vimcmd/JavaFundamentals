package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub18_phasers;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Phaser;

/* # 43 # truck thread */

public class Truck implements Runnable {

    private Phaser phaser;
    private String number;
    private int capacity;
    private Storage storageFrom;
    private Storage storageTo;
    private Queue<Item> bodyStorage;

    public Truck(Phaser phaser, String number, int capacity, Storage storageFrom, Storage storageTo) {
        this.phaser = phaser;
        this.number = number;
        this.capacity = capacity;
        this.storageFrom = storageFrom;
        this.storageTo = storageTo;

        this.bodyStorage = new ArrayDeque<Item>(capacity);
        this.phaser.register();
    }

    @Override
    public void run() {

        System.out.println("Truck #" + number + " arrived with capacity: " + capacity);

        loadTruck();
        System.out.println("Truck #" + number + " loaded by " + bodyStorage.size() + "/" + capacity);
        phaser.arriveAndAwaitAdvance();

        runTruck();
        phaser.arriveAndAwaitAdvance();

        unloadTruck();
        phaser.arriveAndDeregister();
    }

    private void loadTruck() {
        for(int i = 0; i < capacity; i++) {
            Item g = storageFrom.getGood();

            if (g == null) { // if no goods in storage, truck loading interrupts
                return;
            }

            bodyStorage.add(g);
            System.out.println("Truck #" + number + " was loaded good #" + g.getRegistrationNumber());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void unloadTruck() {
        int size = bodyStorage.size();
        for(int i = 0; i < size; i++) {
            Item g = bodyStorage.poll();
            storageTo.addGood(g);
            System.out.println("Truck #" + number + " was unloaded good #" + g.getRegistrationNumber());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void runTruck() {
        try {
            Thread.sleep(new Random(100).nextInt(500));
            System.out.println("Truck #" + number + " started journey");
            Thread.sleep(new Random(100).nextInt(1_000));
            System.out.println("Truck #" + number + " reached warehouse");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
