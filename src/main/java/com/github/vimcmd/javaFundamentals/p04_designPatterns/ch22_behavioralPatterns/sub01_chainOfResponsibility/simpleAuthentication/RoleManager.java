package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch22_behavioralPatterns.sub01_chainOfResponsibility.simpleAuthentication;

// # 4.2 # message handler

public class RoleManager extends AbstractHandler {

    public RoleManager() {
        // some code
    }

    @Override
    public void handleRequest(Employee employee) {
        checkPermission(employee);
    }

    private void checkPermission(Employee employee) {
        System.out.println("checking role");
        // checking role
    }


}
