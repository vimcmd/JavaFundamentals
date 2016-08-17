package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch22_behavioralPatterns.sub02_command.simpleBanking;

public class Client {

    private Receiver receiver;

    public Client(Receiver receiver) {
        this.receiver = receiver;
    }

    public Command initCommand(CommandTypes cmd) {
        Command command = null;
        switch (cmd) {
            case CREDITING:
                System.out.println("Creating command CREDITING & set up its receiver");
                command = new CreditingCommand(receiver);
                break;
            case WITHDRAWING:
                System.out.println("Creating command WITHDRAWING & set up its receiver");
                command = new WithdrawingCommand(receiver);
                break;
            case BLOCKING:
                System.out.println("Creating command BLOCKING & set up its receiver");
                command = new BlockingCommand(receiver);
                break;
        }
        return command;
    }
}
