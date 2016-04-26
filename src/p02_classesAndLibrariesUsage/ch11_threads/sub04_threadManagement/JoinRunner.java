package p02_classesAndLibrariesUsage.ch11_threads.sub04_threadManagement;

/* # 4 # delay thread */

public class JoinRunner {
    static {
        System.out.println("Staring main thread");
    }

    public static void main(String[] args) {
        Thread t1 = new JoinThread("First");
        Thread t2 = new JoinThread("Second");
        //t2.setPriority(Thread.MAX_PRIORITY); // in most cases second thread will be started firstly
        t1.start();
        t2.start();

        try {
            t1.join(); // main thread paused until t1 finish its work
            //t1.join(500); // main thread will be paused for 500 ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Current thread: " + Thread.currentThread().getName()); // name of current thread
    }
}
