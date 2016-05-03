package p02_classesAndLibrariesUsage.ch11_threads.sub19_chapterTasks.parking;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ParkingSpace {
    private String parkingSpaceId;

    public ParkingSpace(String parkingSpaceId) {
        this.parkingSpaceId = parkingSpaceId;
    }

    public String getParkingSpaceId() {
        return parkingSpaceId;
    }

    public void parkCar() {
        try {
            // do something
            int timeout = new Random().nextInt(5_000);
            System.out.println("Parking space #" + getParkingSpaceId() + " now in usage for " + timeout + "ms");
            TimeUnit.MILLISECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
