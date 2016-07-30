package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub01_factoryMethod.simpleWithClientClass;

import com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub01_factoryMethod.simpleWithStaticMethod.AbstractOrder;

public abstract class AbstractOrderFactory {

    public abstract AbstractOrder createOrder();

    public void anOperation() {
        System.out.println("operation");
    }

}
