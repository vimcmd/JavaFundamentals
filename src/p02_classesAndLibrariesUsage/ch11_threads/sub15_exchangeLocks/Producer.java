package p02_classesAndLibrariesUsage.ch11_threads.sub15_exchangeLocks;

/* # 31 # The producer (thread) of the goods, exchanges information about production plan with the consumer
 * (provides information about number of produced goods) */

public class Producer extends Subject implements Runnable {
    public Producer(String name, Item item) {
        super(name, item);
    }

    @Override
    public void run() {
        try {
            synchronized (item) { // synchronization block not necessary but indicative
                int proposedNumber = this.getItem().getNumber();
                // exchange by synchronized instances
                item = exchanger.exchange(item);
                if (proposedNumber <= item.getNumber()) {
                    System.out.println("Producer " + this.getName() + " increases plan of goods production");

                } else {
                    System.out.println("Producer " + this.getName() + " decreases plan of goods production");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
