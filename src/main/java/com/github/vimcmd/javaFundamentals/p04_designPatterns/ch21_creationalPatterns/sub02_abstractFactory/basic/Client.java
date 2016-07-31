package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub02_abstractFactory.basic;

public class Client {

    private AbstractFactory abstractFactory;
    private AbstractProduct abstractProduct;

    public void action() {
        abstractProduct = abstractFactory.createProduct();
        abstractProduct.info();
    }

    public void setAbstractFactory(AbstractFactory factory) {
        this.abstractFactory = factory;
    }

}

