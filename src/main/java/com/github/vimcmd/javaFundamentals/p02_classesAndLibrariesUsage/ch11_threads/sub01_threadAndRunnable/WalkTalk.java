package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub01_threadAndRunnable;

/* # 2.1 # start both threads (on each start order of actions will be different) */

public class WalkTalk {
    public static void main(String[] args) {
        // new child objects
        TalkThread talkThread = new TalkThread();
        Thread walk = new Thread(new WalkRunnable());

        // start threads
        talkThread.start();
        walk.start();
        //WalkRunnable w = new WalkRunnable(); // just object, not child
        //w.run(); talkThread.run(); // just method executed, but thread does not start
    }
}
