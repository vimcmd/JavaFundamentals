package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub04_threadManagement;

public class JoinThread extends Thread {
    public JoinThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        String nameThread = getName();
        long timeout = 0;
        System.out.println("Starting thread " + nameThread);
        try {
            switch (nameThread) {
                case "First":
                    timeout = 5_000;
                    break;
                case "Second":
                    timeout = 1_000;
                    break;
            }

            Thread.sleep(timeout);
            System.out.println("Closing thread " + nameThread);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
