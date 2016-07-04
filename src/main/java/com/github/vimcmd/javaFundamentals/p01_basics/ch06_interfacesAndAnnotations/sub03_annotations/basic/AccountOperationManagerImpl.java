package com.github.vimcmd.javaFundamentals.p01_basics.ch06_interfacesAndAnnotations.sub03_annotations.basic;

// # 19 # methods annotating

public class AccountOperationManagerImpl implements AccountOperationManager {

    @Override
    @BankingAnnotation(securityLevel = SecurityLevelEnum.HIGH)
    public double depositInCash(int accountNumber, int amount) {
        // deposit enrollment
        return 0; // stub
    }

    @Override
    @BankingAnnotation(securityLevel = SecurityLevelEnum.HIGH)
    public boolean withDraw(int accountNumber, int amount) {
        // amount withdrawal, if does not exceed balance
        return true; // stub
    }

    @Override
    @BankingAnnotation(securityLevel = SecurityLevelEnum.LOW)
    public boolean convert(double amount) {
        // convert amount
        return true; // stub
    }

    @Override
    @BankingAnnotation
    public boolean transfer(int accountNumber, double amount) {
        // transfer amount to account
        return true; // stub
    }

}
