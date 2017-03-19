/**
 * 
 */
package info.jonwarren.blog.data;

/**
 * Exception for when the {@link Tag} count is larger than {@link Long#MAX_VALUE}.
 *
 * @author Jon Warren <jon@jonwarren.info>
 */
public class CountOverflowException extends Exception {
    private static final long serialVersionUID = 4519061500163899263L;

    /**
     * Constructs an {@link CountOverflowException} with no detail message.
     */
    public CountOverflowException() {
        super();
    }

    /**
     * Constructs an {@link CountOverflowException} with the specified detail message, cause,
     * enableSuppression, and writableStackTrace.
     * 
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public CountOverflowException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * Constructs an {@link CountOverflowException} with the specified detail message and cause.
     * 
     * @param message
     * @param cause
     */
    public CountOverflowException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs an {@link CountOverflowException} with the specified detail message.
     *
     * @param message
     *            the detail message.
     */
    public CountOverflowException(String message) {
        super(message);
    }

    /**
     * Constructs an {@link CountOverflowException} with the specified cause.
     * 
     * @param cause
     */
    public CountOverflowException(Throwable cause) {
        super(cause);
    }
}
