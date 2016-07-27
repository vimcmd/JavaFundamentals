package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub01_factoryMethod.basic;

public class ConcreteCreator extends Creator {
    @Override
    public Product factoryMethod() {
        // preparatory steps
        this.anOperation();
        return new ConcreteProduct();
    }
}
