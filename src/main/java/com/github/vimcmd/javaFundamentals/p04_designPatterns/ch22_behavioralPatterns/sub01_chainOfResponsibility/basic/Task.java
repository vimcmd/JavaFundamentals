package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch22_behavioralPatterns.sub01_chainOfResponsibility.basic;

public class Task implements BaseInterface {

    private String message = "";

    public Task(String message) {
        this.message = message;
    }

    @Override
    public String handleRequest() {
        System.out.println("Message in task: " + message);
        return message;
    }
}
