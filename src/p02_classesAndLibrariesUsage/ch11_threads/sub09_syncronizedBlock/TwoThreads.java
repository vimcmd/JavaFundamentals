package p02_classesAndLibrariesUsage.ch11_threads.sub09_syncronizedBlock;

/* # 13 # lock object by thread */

public class TwoThreads {
    private static int counter = 0;

    public static void main(String[] args) {
        final StringBuilder sb = new StringBuilder();
        new Thread(){
            @Override
            public void run() {
                synchronized (sb) {
                    do {
                        sb.append("A");
                        System.out.println(sb);
                        try {
                            Thread.sleep(100); // object sb will be locked until synchronized block finished
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } while (TwoThreads.counter++ < 2);
                } // end of synchronized block
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                synchronized (sb) {
                    while (TwoThreads.counter++ < 6) {
                        sb.append("B");
                        System.out.println(sb);
                    }
                } // end of synchronized block
            }
        }.start();
    }
}
