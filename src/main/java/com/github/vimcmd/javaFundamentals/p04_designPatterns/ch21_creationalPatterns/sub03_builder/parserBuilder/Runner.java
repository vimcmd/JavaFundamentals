package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub03_builder.parserBuilder;

public class Runner {

    public static void main(String[] args) {
        User u1 = Director.createUser(new DomBuilder());
        User u2 = Director.createUser(new SaxBuilder());
    }

}
