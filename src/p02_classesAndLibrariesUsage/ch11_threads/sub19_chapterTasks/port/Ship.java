package p02_classesAndLibrariesUsage.ch11_threads.sub19_chapterTasks.port;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Ship implements Runnable, Iterable<Container> {
    // have some goods to load/unload (or both)
    //

    private static final int DEFAULT_CAPACITY = 40;
    private long shipId;
    private int capacity;
    private List<Container> shipStorage = null; // better to use two different storage for load/unload
    private Port port;

    public Ship(Port port, long shipId) {
        this(port, shipId, DEFAULT_CAPACITY);
    }

    public Ship(Port port, long shipId, int capacity) {
        this.port = port;
        this.shipId = shipId;
        this.capacity = capacity;
        shipStorage = new ArrayList<Container>(capacity);
        initStorage();
    }

    public long getShipId() {
        return shipId;
    }

    @Override
    public void run() {
        // load/unload or both
        loadLoop();

        unloadLoop();
    }

    private void loadShip(long timeWaitMillis) {
        if (shipStorage.size() < capacity) {
            try {
                Container container = port.pickGood();
                if (container != null) {
                    System.out.println("Container #" + container.getContainerId() + " loaded to ship #" + this.getShipId());
                    shipStorage.add(container);
                    TimeUnit.MILLISECONDS.sleep(timeWaitMillis);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Not enough space on ship #" + this.shipId);
        }
    }

    private Container unloadShip(long timeWaitMillis) {
        Container container = null;
        try {
            if (shipStorage.isEmpty()) {
                System.out.println("Ship #" + this.shipId + "storage is empty");
                return null;
            }

            while (container == null) {
                container = shipStorage.remove(new Random().nextInt(shipStorage.size()));
            }

            System.out.println("Ship #" + this.shipId + " tries to unload container #" + container.getContainerId());
            port.putGood(container);

            TimeUnit.MILLISECONDS.sleep(timeWaitMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return container;
    }

    private void initStorage() {
        if (new Random().nextInt(2) < 1) { // flip a coin
            int fillCount = new Random().nextInt(capacity);
            System.out.println("Initial  storage fill count for ship #" + this.getShipId() + ": " + fillCount);
            for(int i = 0; i < fillCount; i++) {
                shipStorage.add(new Container(i));
            }
        } else {
            System.out.println("Initial storage empty in ship #" + this.getShipId());
        }
    }

    private void loadLoop() {
        for(int i = 0; i < new Random().nextInt(capacity); i++) {
            loadShip(new Random().nextInt(1_000));
        }
    }

    private void unloadLoop() {
        for(int i = 0; i < new Random().nextInt(shipStorage.size()); i++) {
            unloadShip(new Random().nextInt(1_000));
        }
    }

    private void loadAndUnloadLoop() {
        loadLoop();
        unloadLoop();
    }

    @Override
    public Iterator<Container> iterator() {
        return shipStorage.iterator();
    }
}
