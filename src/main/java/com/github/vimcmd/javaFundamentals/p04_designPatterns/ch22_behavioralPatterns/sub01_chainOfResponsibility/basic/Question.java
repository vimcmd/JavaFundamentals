package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch22_behavioralPatterns.sub01_chainOfResponsibility.basic;

public class Question implements BaseInterface {

    private String message = "";
    private SubTask parent = null;

    public Question(SubTask parent, String message) {
        this.parent = parent;
        this.message = message;
    }

    @Override
    public String handleRequest() {
        System.out.println("Message in question: " + message);
        if (parent == null) {
            return message;
        } else {
            return parent.handleRequest();
        }
    }
}
