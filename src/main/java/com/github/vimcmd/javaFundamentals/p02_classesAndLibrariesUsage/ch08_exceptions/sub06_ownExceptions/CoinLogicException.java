package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch08_exceptions.sub06_ownExceptions;

/* # 6 # Own "logic" exception */

public class CoinLogicException extends Exception {
    public CoinLogicException() {

    }

    public CoinLogicException(String message, Throwable exception) {
        super(message, exception);
    }

    public CoinLogicException(String message) {
        super(message);
    }

    public CoinLogicException(Throwable exception) {
        super(exception);
    }
}
