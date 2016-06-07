package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub16_synchronizedAlternative;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/* # 37 # run process of accessing threads to the resource */

public class LockingRunner {
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 5; i++) {
            ResourcePairedStructure resource = new ResourcePairedStructure();
            new ResourceThread("a" + new Random().nextInt(10), resource).start();
            new ResourceThread("Z" + new Random().nextInt(10), resource).start();
            new ResourceThread("#" + new Random().nextInt(10), resource).start();
            TimeUnit.MILLISECONDS.sleep(1_000);
            System.out.println("Result: " + resource);
            System.out.println();
        }
    }
}
