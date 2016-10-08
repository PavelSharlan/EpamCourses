package by.bsu.audioservice.exception;

/**
 * Class TechnicalException
 * <p>
 * Created by 7 on 06.08.2016.
 */
public class TechnicalException extends Exception {
    /**
     * Instantiates a new Technical exception.
     */
    public TechnicalException() {
    }

    /**
     * Instantiates a new Technical exception.
     *
     * @param message the message
     */
    public TechnicalException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Technical exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public TechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Technical exception.
     *
     * @param cause the cause
     */
    public TechnicalException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Technical exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public TechnicalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
