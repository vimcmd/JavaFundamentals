package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub08_synchronizedMethods;

/* # 12.2 # thread which will write to file */

public class SyncThread extends Thread {
    private Resource resource;

    public SyncThread(String name, Resource resource) {
        super(name);
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            resource.write(getName(), i); // synchronization point
        }
    }
}
