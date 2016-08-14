package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch22_behavioralPatterns.sub01_chainOfResponsibility.simpleAuthentication;

// # 4.3 # message handler

public class TaskManager extends AbstractHandler {

    public TaskManager() {
        // some code
    }

    @Override
    public void handleRequest(Employee employee) {
        assignTask(employee);
    }

    private void assignTask(Employee employee) {
        System.out.println("assign task");
        // assign task
    }


}
