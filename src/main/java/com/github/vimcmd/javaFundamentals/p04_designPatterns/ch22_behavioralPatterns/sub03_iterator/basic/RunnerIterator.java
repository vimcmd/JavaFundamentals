package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch22_behavioralPatterns.sub03_iterator.basic;

public class RunnerIterator {
    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        Iterator iterator = aggregate.createIterator();
        iterator.first();
        while (!iterator.isDone()) {
            Object data = iterator.currentItem();
            iterator.next();
        }
    }
}
