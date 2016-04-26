package p02_classesAndLibrariesUsage.ch11_threads.sub07_atomicTypesAndVolatileModifier;

/* # 10 # recipient of atomic field value */

public class Broker extends Thread {
    private static final int PAUSE = 500; // in millis
    private Market market;

    public Broker(String name, Market market) {
        super(name);
        this.market = market;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(getName() + " current atomic index: " + market.getIndex());
                Thread.sleep(PAUSE);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
