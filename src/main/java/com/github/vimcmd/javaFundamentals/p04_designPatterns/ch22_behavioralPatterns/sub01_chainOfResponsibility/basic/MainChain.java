package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch22_behavioralPatterns.sub01_chainOfResponsibility.basic;

// configure and start chain

public class MainChain {

    public static void main(String[] args) {
        // configure chain
        Task root = new Task("Pass the exam");
        SubTask subTask = new SubTask(root, "Complete test");
        Question question = new Question(subTask, "Pass lab work");
        // execute
        System.out.println("Message from question < " + question.handleRequest() + " >");
    }

}
