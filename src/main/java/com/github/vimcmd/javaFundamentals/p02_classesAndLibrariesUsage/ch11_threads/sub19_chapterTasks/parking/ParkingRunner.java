package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub19_chapterTasks.parking;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class ParkingRunner {
    public static void main(String[] args) throws InterruptedException {

        Queue<ParkingSpace> parkingSpaces = new LinkedList<>();
        for(int i = 0; i < 5; i++) {
            parkingSpaces.add(new ParkingSpace("" + i));
        }

        ParkingGarage<ParkingSpace> garage = new ParkingGarage<>(parkingSpaces);

        for(int i = 0; i < 20; i++) {
            new Thread(new Car("car#" + i, garage)).start();
            TimeUnit.MILLISECONDS.sleep(200);
        }
    }
}
