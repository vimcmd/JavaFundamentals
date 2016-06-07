package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub03_threadsPriority;

/* # 3 # threads priority demonstration */

public class PriorityThread extends Thread {
    public PriorityThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for(int i = 0; i < 71; i++) {
            if (i >= 70) {
                System.out.println(getName() + " " + i + " FINISHED");
            } else {
                System.out.println(getName() + " " + i);
            }
            try {
                Thread.sleep(2); // try sleep(0), sleep(10)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
