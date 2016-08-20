package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch22_behavioralPatterns.sub03_iterator.basic;

public class ConcreteAggregate implements Aggregate {
    @Override
    public Iterator createIterator() {
        System.out.println("Creating concrete iterator for concrete aggregate.");
        Iterator iterator = new ConcreteIterator(this);
        return iterator;
    }
}
