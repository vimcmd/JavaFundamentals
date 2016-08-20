package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch22_behavioralPatterns.sub03_iterator.basic;

public class ConcreteIterator implements Iterator {
    private ConcreteAggregate concreteAggregate;

    public ConcreteIterator(ConcreteAggregate concreteAggregate) {
        this.concreteAggregate = concreteAggregate;
    }

    @Override
    public void first() {
        // first element in concreteAggregate
    }

    @Override
    public boolean isDone() {
        // Check whether the end is reached
        return true;
    }

    @Override
    public void next() {
        // Next element in concreteAggregate
    }

    @Override
    public Object currentItem() {
        // Return current item in concreteAggregate
        return null;
    }
}
