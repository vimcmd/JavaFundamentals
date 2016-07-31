package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub02_abstractFactory.basic;

public class ConcreteProduct implements AbstractProduct {

    // fields, constructors and methods

    @Override
    public void info() {
        System.out.println("Concrete product");
    }

}
