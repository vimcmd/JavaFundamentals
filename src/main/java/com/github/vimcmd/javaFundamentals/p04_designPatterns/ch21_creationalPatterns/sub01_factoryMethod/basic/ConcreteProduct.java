package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub01_factoryMethod.basic;

public class ConcreteProduct implements Product {

    // fields, constructors

    @Override
    public void check() {
        System.out.println("concrete product");
    }
}
