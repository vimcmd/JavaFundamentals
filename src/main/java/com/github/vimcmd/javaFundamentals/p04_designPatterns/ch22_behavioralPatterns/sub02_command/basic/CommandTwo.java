package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch22_behavioralPatterns.sub02_command.basic;

public class CommandTwo implements Command {

    private Receiver receiver;

    public CommandTwo(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        System.out.println("Determine connection between receiver and action");
        receiver.action(CommandType.TWO);
    }
}
