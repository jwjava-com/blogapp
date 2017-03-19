/**
 * 
 */
package info.jonwarren.blog.data;

/**
 * Exception for when a name is invalid.
 *
 * @author Jon Warren <jon@jonwarren.info>
 */
public class InvalidNameException extends Exception {
    private static final long serialVersionUID = 6708508859426234102L;

    /**
     * Constructs an {@link InvalidNameException} with no detail message.
     */
    public InvalidNameException() {
        super();
    }

    /**
     * Constructs an {@link InvalidNameException} with the specified detail message, cause,
     * enableSuppression, and writableStackTrace.
     * 
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public InvalidNameException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * Constructs an {@link InvalidNameException} with the specified detail message and cause.
     * 
     * @param message
     * @param cause
     */
    public InvalidNameException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs an {@link InvalidNameException} with the specified detail message.
     *
     * @param message
     */
    public InvalidNameException(String message) {
        super(message);
    }

    /**
     * Constructs an {@link InvalidNameException} with the specified cause.
     * 
     * @param cause
     */
    public InvalidNameException(Throwable cause) {
        super(cause);
    }
}
