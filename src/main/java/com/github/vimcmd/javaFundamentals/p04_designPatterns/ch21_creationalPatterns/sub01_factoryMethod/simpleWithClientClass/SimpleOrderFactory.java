package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub01_factoryMethod.simpleWithClientClass;

import com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub01_factoryMethod.simpleWithStaticMethod.AbstractOrder;
import com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub01_factoryMethod.simpleWithStaticMethod.SimpleOrder;

public class SimpleOrderFactory extends AbstractOrderFactory {

    @Override
    public AbstractOrder createOrder() {
        return new SimpleOrder();
    }
}
