package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub01_factoryMethod.simpleWithGenerics;

import com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub01_factoryMethod.simpleWithStaticMethod.SimpleOrder;

public class SimpleOrderFactory extends AbstractOrderFactory<SimpleOrder> {

    @Override
    public SimpleOrder createInstance() {
        return new SimpleOrder();
    }
}
