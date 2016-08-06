package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub03_builder.basic;

public class Runner {

    public static void main(String[] args) {
        Director director = new Director("Concrete");
        Product product = director.construct("sourcePath");
    }

}
