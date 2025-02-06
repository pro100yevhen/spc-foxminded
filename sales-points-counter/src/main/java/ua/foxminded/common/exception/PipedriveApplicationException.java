package ua.foxminded.common.exception;

public abstract class PipedriveApplicationException extends RuntimeException {

    public PipedriveApplicationException(final String message) {
        super(message);
    }

    public PipedriveApplicationException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public PipedriveApplicationException(final Throwable cause) {
        super(cause);
    }
}
