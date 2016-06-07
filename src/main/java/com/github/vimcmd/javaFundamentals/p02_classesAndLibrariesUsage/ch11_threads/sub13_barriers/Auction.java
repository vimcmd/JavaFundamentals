package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub13_barriers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.CyclicBarrier;

/* # 23 # defining barrier and its action on breaking */

public class Auction {
    public final int BIDS_NUMBER = 5;
    private ArrayList<Bid> bids;
    private CyclicBarrier barrier;

    public Auction() {
        this.bids = new ArrayList<Bid>();

        this.barrier = new CyclicBarrier(this.BIDS_NUMBER, new Runnable() {
            @Override
            public void run() {
                Bid winner = Auction.this.defineWinner();
                System.out.println("Ladies and gentleman's, bid #" + winner.getBidId() + ", with price " + winner.getPrice() + " win!");
            }
        });
    }

    public CyclicBarrier getBarrier() {
        return barrier;
    }

    public boolean addBid(Bid e) {
        return bids.add(e);
    }

    public Bid defineWinner() {
        return Collections.max(bids, new Comparator<Bid>() {
            @Override
            public int compare(Bid o1, Bid o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
    }
}
