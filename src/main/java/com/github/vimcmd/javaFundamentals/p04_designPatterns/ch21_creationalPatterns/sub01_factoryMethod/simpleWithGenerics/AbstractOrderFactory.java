package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub01_factoryMethod.simpleWithGenerics;

import com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub01_factoryMethod.simpleWithStaticMethod.AbstractOrder;

public abstract class AbstractOrderFactory<T extends AbstractOrder> {

    public abstract T createInstance();

    public void anOperation() {
        System.out.println("operation");
    }
}
