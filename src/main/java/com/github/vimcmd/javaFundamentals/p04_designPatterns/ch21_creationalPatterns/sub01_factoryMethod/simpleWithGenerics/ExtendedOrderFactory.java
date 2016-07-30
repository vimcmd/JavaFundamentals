package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub01_factoryMethod.simpleWithGenerics;

import com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub01_factoryMethod.simpleWithStaticMethod.ExtendedOrder;

public class ExtendedOrderFactory extends AbstractOrderFactory<ExtendedOrder> {
    @Override
    public ExtendedOrder createInstance() {
        return new ExtendedOrder();
    }
}
