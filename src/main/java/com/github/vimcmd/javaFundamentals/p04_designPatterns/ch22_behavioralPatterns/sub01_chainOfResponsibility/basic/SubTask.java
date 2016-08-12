package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch22_behavioralPatterns.sub01_chainOfResponsibility.basic;

public class SubTask implements BaseInterface {

    private String message = "";
    private Task root = null;

    public SubTask(Task root, String message) {
        this.root = root;
        this.message = message;
    }

    @Override
    public String handleRequest() {
        System.out.println("Message in SubTask: " + message);
        if (root == null) {
            return message;
        } else {
            return root.handleRequest();
        }
    }
}
