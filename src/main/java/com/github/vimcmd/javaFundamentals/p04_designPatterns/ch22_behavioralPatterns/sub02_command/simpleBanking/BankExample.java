package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch22_behavioralPatterns.sub02_command.simpleBanking;

public class BankExample {

    public static void main(String[] args) {
        Account account = new Account(210012, 1100, false);
        Receiver receiver = new Receiver(account);
        Client client = new Client(receiver);

        Command creditingCommand = client.initCommand(CommandTypes.CREDITING);
        Invoker creditingInvoker = new Invoker(creditingCommand);
        creditingInvoker.invokeCommand();

        Command withdrawingCommand = client.initCommand(CommandTypes.WITHDRAWING);
        Invoker withdrawingInvoker = new Invoker(withdrawingCommand);
        withdrawingInvoker.invokeCommand();

        Command blockingCommand = client.initCommand(CommandTypes.BLOCKING);
        Invoker blockingInvoker = new Invoker(blockingCommand);
        blockingInvoker.invokeCommand();
    }

}
