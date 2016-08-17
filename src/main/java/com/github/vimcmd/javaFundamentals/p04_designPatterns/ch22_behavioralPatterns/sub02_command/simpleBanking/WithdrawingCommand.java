package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch22_behavioralPatterns.sub02_command.simpleBanking;

public class WithdrawingCommand implements Command {

    private Receiver receiver;

    public WithdrawingCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action(CommandTypes.WITHDRAWING);
    }
}
