package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub05_prototype.generic;

public class Book extends Issue {

    private String author;

    public Book(Integer id, String author, String name, int year) {
        super(id, name, year);
        this.author = author;
    }
}
