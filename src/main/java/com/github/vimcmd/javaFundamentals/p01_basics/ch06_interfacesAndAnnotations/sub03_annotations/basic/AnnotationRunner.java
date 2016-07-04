package com.github.vimcmd.javaFundamentals.p01_basics.ch06_interfacesAndAnnotations.sub03_annotations.basic;

// # 20 # configure and run

public class AnnotationRunner {

    public static void main(String[] args) {
        AccountOperationManager account = new AccountOperationManagerImpl();
        // "class registration" to include annotations into processing
        // NOTE: approach with calling some "intermediate" method to include annotation processing
        // are common and particularly used in JPA
        AccountOperationManager securityAccount = SecurityFactory.createSecurityObject(account);

        securityAccount.depositInCash(10128336, 6);
        securityAccount.withDraw(64092376, 2);
        securityAccount.convert(200);
        securityAccount.transfer(64092376, 300);
    }

}
