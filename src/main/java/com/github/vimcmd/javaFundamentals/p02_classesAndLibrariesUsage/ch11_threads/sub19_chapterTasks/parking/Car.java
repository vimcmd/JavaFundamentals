package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub19_chapterTasks.parking;

import java.util.Random;

public class Car implements Runnable {

    private ParkingGarage<ParkingSpace> parkingGarage;
    private String carId;
    private boolean parked;

    public Car(String carId, ParkingGarage parkingGarage) {
        this.carId = carId;
        this.parkingGarage = parkingGarage;
        this.parked = false;
    }

    public String getCarId() {
        return carId;
    }

    @Override
    public void run() {
        ParkingSpace p = null;
        try {
            int waitTimeout = new Random().nextInt(2_000);
            p = parkingGarage.getParkingSpace(waitTimeout);
            if (p != null) {
                parked = true;
                System.out.println(getCarId() + " parked at parking space #" + p.getParkingSpaceId());
                p.parkCar();
            } else {
                System.out.println(getCarId() + " did not waited for free space and left to another parking garage");
            }
        } finally {
            if (p != null) {
                parked = false;
                parkingGarage.releaseParkingSpace(p);
                System.out.println(getCarId() + " leave, parking space #" + p.getParkingSpaceId() + " now free");
            }
        }
    }
}
