package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub01_factoryMethod.simple;

public class FactoryMethodRunnerSimple {

    public static void main(String[] args) {
        AbstractOrder o1 = OrderFactory.createOrderFromFactory("simple");
        AbstractOrder o2 = OrderFactory.createOrderFromFactory("extended");
        o1.perform();
        o2.perform();

        AbstractOrder expectedException = OrderFactory.createOrderFromFactory("expected_exception");
    }

}
