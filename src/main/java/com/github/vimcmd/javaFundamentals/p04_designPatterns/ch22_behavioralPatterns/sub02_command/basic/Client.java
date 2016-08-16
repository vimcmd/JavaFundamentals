package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch22_behavioralPatterns.sub02_command.basic;

public class Client {

    private Receiver receiver;

    public Client(Receiver receiver) {
        this.receiver = receiver;
    }

    public Command initCommand(CommandType cmd) {
        Command command = null;
        switch (cmd) {
            case ONE:
                System.out.println("Creating command ONE and set up its receiver");
                command = new CommandOne(receiver);
                break;
            case TWO:
                System.out.println("Creating command TWO and set up its receiver");
                command = new CommandTwo(receiver);
                break;
        }
        return command;
    }
}
