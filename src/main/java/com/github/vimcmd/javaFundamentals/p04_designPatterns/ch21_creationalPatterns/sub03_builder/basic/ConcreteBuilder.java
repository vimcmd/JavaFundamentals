package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub03_builder.basic;

public class ConcreteBuilder implements Builder {

    private Product product = new Product();

    @Override
    public Product getProduct() {
        return product;
    }

    @Override
    public void buildPart1(int part1) {
        // implementation
        product.setPart1(part1);
    }

    @Override
    public void buildPart2(String part2) {
        // implementation
        product.setPart2(part2);
    }
}
