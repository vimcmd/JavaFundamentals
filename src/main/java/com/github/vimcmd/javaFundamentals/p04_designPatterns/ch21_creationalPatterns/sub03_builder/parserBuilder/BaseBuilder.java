package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub03_builder.parserBuilder;

public abstract class BaseBuilder {

    protected User user = new User();

    public User getUser() {
        return user;
    }

    public abstract void buildLogin();

    public abstract void buildPassword();

    // public abstract void buildUser(); // also possible
}
