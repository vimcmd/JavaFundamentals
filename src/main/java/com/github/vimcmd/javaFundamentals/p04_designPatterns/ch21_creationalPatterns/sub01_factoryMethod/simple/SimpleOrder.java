package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub01_factoryMethod.simple;

public class SimpleOrder extends AbstractOrder {

    // fields and methods

    @Override
    public void perform() {
        System.out.println("Simple order");
    }

}
