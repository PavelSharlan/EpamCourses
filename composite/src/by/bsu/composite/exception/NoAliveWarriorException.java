package by.bsu.composite.exception;

public class NoAliveWarriorException extends Exception {
    public NoAliveWarriorException() {
    }

    public NoAliveWarriorException(String message) {
        super(message);
    }

    public NoAliveWarriorException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoAliveWarriorException(Throwable cause) {
        super(cause);
    }

    public NoAliveWarriorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
