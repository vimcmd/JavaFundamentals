package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub05_prototype.generic;

public class Magazine extends Issue {

    private int number;

    public Magazine(Integer id, int number, String name, int year) {
        super(id, name, year);
        this.number = number;
    }
}
