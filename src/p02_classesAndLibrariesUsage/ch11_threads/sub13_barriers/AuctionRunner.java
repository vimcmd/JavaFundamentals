package p02_classesAndLibrariesUsage.ch11_threads.sub13_barriers;

/* # 25 # auction initialization and start */

import java.util.Random;

public class AuctionRunner {
    public static void main(String[] args) {
        Auction auction = new Auction();
        int startPrice = new Random().nextInt(100);

        // if running threads quantity will be greater than barrier size, some bids may be not considered
        // otherwise, if threads count will be less than barrier size, there will be 'deadlock'
        // to prevent this situations may use await() with arguments
        for(int i = 0; i < auction.BIDS_NUMBER; i++) {
            Bid thread = new Bid(i, startPrice, auction.getBarrier());
            auction.addBid(thread);
            thread.start();
        }
    }
}
