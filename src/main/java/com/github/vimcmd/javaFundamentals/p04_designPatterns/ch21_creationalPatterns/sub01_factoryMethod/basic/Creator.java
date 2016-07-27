package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub01_factoryMethod.basic;

public abstract class Creator {

    public abstract Product factoryMethod();

    public void anOperation() {
        System.out.println("operation");
    }

}
