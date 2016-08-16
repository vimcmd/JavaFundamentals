package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch22_behavioralPatterns.sub02_command.basic;

public class CommandRunner {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Client client = new Client(receiver);

        Command commandOne = client.initCommand(CommandType.ONE);
        Invoker invokerOne = new Invoker(commandOne);
        invokerOne.invokeCommand();

        Command commandTwo = client.initCommand(CommandType.TWO);
        Invoker invokerTwo = new Invoker(commandTwo);
        invokerTwo.invokeCommand();
    }

}
