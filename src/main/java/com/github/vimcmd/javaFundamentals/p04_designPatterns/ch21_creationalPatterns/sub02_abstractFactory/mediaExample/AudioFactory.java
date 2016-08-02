package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub02_abstractFactory.mediaExample;

public class AudioFactory extends AbstractMediaFactory {
    @Override
    public TcpMediaContent createTcpObject() {
        return new TcpAudioContent();
    }

    @Override
    public UdpMediaContent createUdpObject() {
        return new UdpAudioContent();
    }
}
