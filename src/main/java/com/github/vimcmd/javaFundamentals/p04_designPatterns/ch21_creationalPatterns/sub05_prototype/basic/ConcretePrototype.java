package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub05_prototype.basic;

// # 22 # implementation a class with creating copy of its own instance

public class ConcretePrototype implements Prototype {

    // fields and polymorphic methods

    @Override
    public Prototype clonePrototype() {
        // object (clone) prototyping process implementation
        return new ConcretePrototype();
    }
}
