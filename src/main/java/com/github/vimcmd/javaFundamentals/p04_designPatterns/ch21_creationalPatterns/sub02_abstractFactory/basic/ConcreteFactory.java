package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub02_abstractFactory.basic;

public class ConcreteFactory implements AbstractFactory {

    @Override
    public AbstractProduct createProduct() {
        System.out.println("Creating concrete product");
        return new ConcreteProduct();
    }

}
