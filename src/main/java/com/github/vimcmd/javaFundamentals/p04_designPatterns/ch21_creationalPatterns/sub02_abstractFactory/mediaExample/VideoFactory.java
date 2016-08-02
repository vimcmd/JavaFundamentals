package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub02_abstractFactory.mediaExample;

public class VideoFactory extends AbstractMediaFactory {
    @Override
    public TcpMediaContent createTcpObject() {
        return new TcpVideoContent();
    }

    @Override
    public UdpMediaContent createUdpObject() {
        return new UdpVideoContent();
    }
}
