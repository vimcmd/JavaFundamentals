package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub02_abstractFactory.mediaExample;

public abstract class AbstractMediaFactory {

    public abstract TcpMediaContent createTcpObject();

    public abstract UdpMediaContent createUdpObject();

}
