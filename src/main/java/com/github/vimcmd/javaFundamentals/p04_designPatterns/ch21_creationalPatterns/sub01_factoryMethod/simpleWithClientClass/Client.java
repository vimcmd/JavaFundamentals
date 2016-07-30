package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub01_factoryMethod.simpleWithClientClass;

import com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub01_factoryMethod.simpleWithStaticMethod.AbstractOrder;

public class Client {

    // fields and methods

    public void someOperation(AbstractOrderFactory factory) {
        AbstractOrder order = factory.createOrder();
        order.perform();
    }
}
