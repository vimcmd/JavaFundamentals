package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub19_chapterTasks.port;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Port {

    private Storage storage;
    private Semaphore semaphore;

    public Port(Storage storage, int docksCount) {
        this.storage = storage;
        this.semaphore = new Semaphore(docksCount, true); // grant FIFO
    }

    public Container pickGood() {
        try {
            semaphore.acquire();
            Container container = storage.pickRandom(new Random().nextInt(1_000));
            if (container != null) {
                System.out.println("Container #" + container.getContainerId() + " unloaded from port storage");
                return container;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return null;
    }

    public void putGood(Container container) {
        try {
            semaphore.acquire();
            if (container != null) {
                storage.put(container, new Random().nextInt(1_000));
                System.out.println("Container #" + container.getContainerId() + " loaded to port storage");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

}
