package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub12_semaphores;

import java.util.Random;

/* # 19 # channel - resource: usual class with some data */

public class AudioChannel {
    private int channelId;

    public AudioChannel(int channelId) {
        super();
        this.channelId = channelId;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public void using() {
        try {
            // some channel usage
            Thread.sleep(new Random().nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
