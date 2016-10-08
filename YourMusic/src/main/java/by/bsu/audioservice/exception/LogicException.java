package by.bsu.audioservice.exception;

/**
 * Class LogicException
 *
 * Created by 7 on 06.08.2016.
 */
public class LogicException extends Exception {
    /**
     * Instantiates a new Logic exception.
     */
    public LogicException() {
    }

    /**
     * Instantiates a new Logic exception.
     *
     * @param message the message
     */
    public LogicException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Logic exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public LogicException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Logic exception.
     *
     * @param cause the cause
     */
    public LogicException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Logic exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public LogicException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
