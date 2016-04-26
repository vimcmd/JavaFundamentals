package p02_classesAndLibrariesUsage.ch11_threads.sub01_threadAndRunnable;

/* # 1 # extending from Thread class */

public class TalkThread extends Thread {
    @Override
    public void run() {
        //super.run();
        for(int i = 0; i < 5; i++) {
            System.out.println("Talking");
            try {
                Thread.sleep(10); // pause for 10 ms
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }
}
