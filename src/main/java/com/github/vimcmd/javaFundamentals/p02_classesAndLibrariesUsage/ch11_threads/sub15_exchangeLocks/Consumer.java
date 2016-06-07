package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub15_exchangeLocks;

/* # 32 # the consumer (thread) of goods, exchanges level of sales with producer
* (provides information about number of sold goods) */

public class Consumer extends Subject implements Runnable {
    public Consumer(String name, Item item) {
        super(name, item);
    }

    @Override
    public void run() {
        try {
            synchronized (item) { // synchronization block not necessary but indicative
                int requiredNumber = this.item.getNumber();
                item = exchanger.exchange(item);
                if (requiredNumber >= item.getNumber()) {
                    System.out.println("Consumer " + this.getName() + " increases cost of goods");
                } else {
                    System.out.println("Consumer " + this.getName() + " decreases cost of goods");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
