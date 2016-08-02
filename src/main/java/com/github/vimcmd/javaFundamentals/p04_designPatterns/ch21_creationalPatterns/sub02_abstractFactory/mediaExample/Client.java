package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub02_abstractFactory.mediaExample;

public class Client {
    private TcpMediaContent tcpMediaContent;
    private UdpMediaContent udpMediaContent;

    public void makeMediaFactoryWork(AbstractMediaFactory factory) {
        tcpMediaContent = factory.createTcpObject();
        udpMediaContent = factory.createUdpObject();
        // object usage
    }
}
