package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub16_synchronizedAlternative;

/* # 36 # thread access to resource */

import java.util.Random;

public class ResourceThread extends Thread {
    private ResourcePairedStructure resource;

    public ResourceThread(String name, ResourcePairedStructure resource) {
        super(name);
        this.resource = resource;
    }

    @Override
    public void run() {
        int deletions = 0;
        int insertions = 0;
        for(int i = 0; i < 4; i++) {
            if (new Random().nextInt(2) > 0) {
                resource.adding(this.getName(), i);
                insertions++;
            } else {
                resource.deleting();
                deletions++;
            }
        }
        System.out.println("Thread " + this.getName() + " insertions: " + insertions + ", deletions: " + deletions);
    }
}
