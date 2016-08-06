package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub03_builder.basic;

public interface Builder {

    Product getProduct();

    void buildPart1(int part1);

    void buildPart2(String part2);

}
