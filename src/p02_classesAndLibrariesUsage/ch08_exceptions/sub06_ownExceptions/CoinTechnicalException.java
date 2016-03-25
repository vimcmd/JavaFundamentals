package p02_classesAndLibrariesUsage.ch08_exceptions.sub06_ownExceptions;

/* # 8 # Own "technical" exception */

public class CoinTechnicalException extends Exception {
    public CoinTechnicalException() {
    }

    public CoinTechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoinTechnicalException(String message) {
        super(message);
    }

    public CoinTechnicalException(Throwable cause) {
        super(cause);
    }
}
