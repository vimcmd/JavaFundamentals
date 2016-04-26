package p02_classesAndLibrariesUsage.ch11_threads.sub05_threadDaemons;

public class SimpleThread extends Thread {
    @Override
    public void run() {
        try {
            if (isDaemon()) {
                System.out.println("Starting daemon thread");
                Thread.sleep(10_000); // try change to 1
            } else {
                System.out.println("Starting normal thread");
                Thread.sleep(1_000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (!isDaemon()) {
                System.out.println("Finishing normal thread");
            } else {
                System.out.println("Finishing daemon thread");
            }
        }
    }
}
