package com.github.vimcmd.javaFundamentals.p01_basics.ch06_interfacesAndAnnotations.sub03_annotations.basic;

public interface AccountOperationManager {

    double depositInCash(int accountNumber, int amount);

    boolean withDraw(int accountNumber, int amount);

    boolean convert(double amount);

    boolean transfer(int accountNumber, double amount);
}
