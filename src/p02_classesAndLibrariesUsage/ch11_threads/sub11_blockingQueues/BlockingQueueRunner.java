package p02_classesAndLibrariesUsage.ch11_threads.sub11_blockingQueues;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/* # 16 # demonstration of possibilities of blocking queue */

public class BlockingQueueRunner {
    public static void main(String[] args) {
        final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);

        new Thread() {
            @Override
            public void run() {
                for(int i = 0; i < 3; i++) {
                    try {
                        queue.put("Java " + i); // adding 3 elements
                        // last element will be added when second thread takes head of queue
                        System.out.println("element " + i + " added");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3_000);
                    // extract one element
                    System.out.println("element " + queue.take() + " took");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
