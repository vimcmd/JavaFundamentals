package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub13_barriers;

/* # 24 # thread whose using barrier */

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Bid extends Thread {

    private Integer bidId;
    private int price;
    private CyclicBarrier barrier;

    public Bid(int bidId, int price, CyclicBarrier barrier) {
        this.bidId = bidId;
        this.price = price;
        this.barrier = barrier;
    }

    public Integer getBidId() {
        return bidId;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public void run() {
        try {
            System.out.println("Client #" + this.bidId + " specifies price");
            Thread.sleep(new Random().nextInt(3_000)); // thinking time

            int delta = new Random().nextInt(50);
            price += delta;
            System.out.println("Bid #" + this.bidId + " price: " + this.price);
            this.barrier.await(); // pause at the barrier

            System.out.println("Client #" + this.bidId + " continue to work..."); // check who wins
            // pay on bid win

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
