package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch22_behavioralPatterns.sub02_command.basic;

public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void invokeCommand() {
        System.out.println("Refer to command for execution");
        command.execute();
    }
}
