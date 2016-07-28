package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub01_factoryMethod.simple;

public class OrderFactoryVariant {

    // fields and methods

    public SimpleOrder createSimpleOrder() {
        return new SimpleOrder();
    }

    public ExtendedOrder createExtendedOrder() {
        return new ExtendedOrder();
    }

    public void anOperation() {
        System.out.println("operation");
    }

}
