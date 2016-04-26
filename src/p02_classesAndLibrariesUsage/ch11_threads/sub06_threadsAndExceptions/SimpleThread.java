package p02_classesAndLibrariesUsage.ch11_threads.sub06_threadsAndExceptions;

/* # 8.1 # */

public class SimpleThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
            System.err.println(e);
        }
        System.out.println("end of SimpleThread");
    }
}
