package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub03_builder.basic;

public class Director {

    private Builder builder; // field not necessary

    public Director(String builderMod) {
        // init builder
    }

    public Product construct(String sourceName) {
        builder.buildPart1(23); // some argument
        builder.buildPart2("awesome part 2"); // another argument
        return builder.getProduct();
    }
}
