package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub19_chapterTasks.parking;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ParkingGarage<T> {

    private final static int DEFAULT_POOL_SIZE = 10;
    private Semaphore semaphore;
    private Queue<T> parkingSpaces;

    public ParkingGarage(Queue<T> parkingSpaces) {
        this.parkingSpaces = new LinkedList<T>();
        semaphore = new Semaphore(parkingSpaces.size(), true);
        this.parkingSpaces.addAll(parkingSpaces);
    }

    public T getParkingSpace(long waitTimeout) {
        try {
            if (semaphore.tryAcquire(waitTimeout, TimeUnit.MILLISECONDS)) {
                return parkingSpaces.poll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void releaseParkingSpace(T parkingSpace) {
        parkingSpaces.add(parkingSpace);
        semaphore.release();
    }
}
