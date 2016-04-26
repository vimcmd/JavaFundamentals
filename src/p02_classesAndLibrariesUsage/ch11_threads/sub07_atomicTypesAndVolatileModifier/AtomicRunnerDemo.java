package p02_classesAndLibrariesUsage.ch11_threads.sub07_atomicTypesAndVolatileModifier;

/* # 11 # start thread to change atomic value and track it with few other threads */

import java.util.concurrent.atomic.AtomicLong;

public class AtomicRunnerDemo {
    private static final int BROKERS_COUNT = 40;

    public static void main(String[] args) {
        Market market = new Market(new AtomicLong(100));
        market.start();

        for(int i = 0; i < BROKERS_COUNT; i++) {
            new Broker("Broker" + i, market).start();
        }
    }
}
