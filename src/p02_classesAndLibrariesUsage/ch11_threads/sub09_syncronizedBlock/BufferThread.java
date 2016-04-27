package p02_classesAndLibrariesUsage.ch11_threads.sub09_syncronizedBlock;

/* # 14 # thread-safety of StringBuffer class demonstration */

public class BufferThread {
    private static int counter = 0;
    private static StringBuffer s = new StringBuffer("string: "); // try to replace with StringBuilder and see result

    public static void main(String[] args) throws InterruptedException {
        new Thread(){
            @Override
            public void run() {
                synchronized (s) {
                    while (BufferThread.counter++ < 5) {
                        s.append("A");
                        System.out.print("second thread step " + counter + ", ");
                        System.out.println(s);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } // end of synchronized block
            }
        }.start();

        Thread.sleep(500);

        while (BufferThread.counter++ < 9) {
            System.out.print("main thread step " +counter + ", ");
            // in this place main thread will be paused until 's' object will be unlocked
            s.append("B");
            System.out.println(s);
        }
    }
}
