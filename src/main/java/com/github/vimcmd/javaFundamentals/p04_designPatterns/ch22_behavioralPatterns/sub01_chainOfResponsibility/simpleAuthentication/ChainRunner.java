package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch22_behavioralPatterns.sub01_chainOfResponsibility.simpleAuthentication;

// # 7 # configure and start

public class ChainRunner {

    public static void main(String[] args) {
        Employee user = new Employee(30, "user", "qwerty");
        // configure chain
        RoleManager roleManager = new RoleManager();
        Authentication authentication = new Authentication();
        TaskManager taskManager = new TaskManager();
        authentication.setSuccessor(roleManager);
        roleManager.setSuccessor(taskManager);
        System.out.println("##### start chain #####");
        authentication.chain(user);
    }

}
