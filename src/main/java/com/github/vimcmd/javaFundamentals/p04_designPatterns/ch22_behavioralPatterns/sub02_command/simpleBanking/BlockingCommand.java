package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch22_behavioralPatterns.sub02_command.simpleBanking;

public class BlockingCommand implements Command {

    private Receiver receiver;

    public BlockingCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action(CommandTypes.BLOCKING);
    }
}
