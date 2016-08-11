package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub05_prototype.basic;

// # 23 # class, creates and uses copy of instance

public class Client {

    private Prototype mPrototype;

    public void operation() {
        Prototype instance = mPrototype.clonePrototype();
        // actions with clone
    }

}
