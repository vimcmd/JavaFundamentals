package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub02_abstractFactory.basic;

public class Runner {

    public static void main(String[] args) {
        Client client = new Client();
        client.setAbstractFactory(new ConcreteFactory());
        client.action();
    }

}
