package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub01_factoryMethod.simple;

// Simple pattern realization

public class OrderFactory {

    public static AbstractOrder createOrderFromFactory(String type) {
        TypeOrder sign = TypeOrder.valueOf(type.toUpperCase());
        switch (sign) {
            case SIMPLE:
                return new SimpleOrder();
            case EXTENDED:
                return new ExtendedOrder();
            default:
                throw new EnumConstantNotPresentException(TypeOrder.class, sign.name());
        }
    }

    public void anOperator() {
        System.out.println("Operation");
    }

}
