package com.github.vimcmd.javaFundamentals.p01_basics.ch06_interfacesAndAnnotations.sub03_annotations.basic;

import java.lang.reflect.Method;

// # 21 # annotation value processing logic

public class SecurityLogic {

    public void onInvoke(SecurityLevelEnum level, Method method, Object[] args) {

        StringBuilder argsString = new StringBuilder();

        for(Object arg : args) {
            argsString.append(arg.toString() + "; ");
        }

        argsString.setLength(argsString.length() - 1);

        System.out.println(String.format(
                "Method %S was invoked with arguments: %s", method.getName(), argsString.toString()
        ));

        switch (level) {
            case LOW:
                System.out.println("LOW security audit level: " + level);
                break;
            case NORMAL:
                System.out.println("NORMAL security audit level: " + level);
                break;
            case HIGH:
                System.out.println("HIGH security audit level: " + level);
                break;
        }
    }

}
