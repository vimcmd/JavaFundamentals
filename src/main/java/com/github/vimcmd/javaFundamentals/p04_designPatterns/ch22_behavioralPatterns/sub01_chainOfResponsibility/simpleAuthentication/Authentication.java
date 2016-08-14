package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch22_behavioralPatterns.sub01_chainOfResponsibility.simpleAuthentication;

// # 4.1 # message handler

public class Authentication extends AbstractHandler {

    public Authentication() {
        // some code
    }

    @Override
    public void handleRequest(Employee employee) {
        if (checkStatus(employee)) {
            // some code
        }
    }

    public boolean checkStatus(Employee employee) {
        boolean flag = true;
        System.out.println(employee);
        System.out.println("check user status");
        // check user status
        return flag;
    }
}
