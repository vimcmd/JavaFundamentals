package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch22_behavioralPatterns.sub02_command.basic;

public class Receiver {

    public void action(CommandType cmd) {
        switch (cmd) {
            case ONE:
                System.out.println("Know information to complete request ONE");
                break;
            case TWO:
                System.out.println("Know information to complete request TWO");
                break;
        }
    }

}
