package ua.foxminded.common.exception;

import static java.lang.String.format;

public class JsonParsingException extends PipedriveApplicationException{

    public JsonParsingException(final Throwable cause, final String messageTemplate, final Object... args) {
        super(format(messageTemplate, args), cause);
    }
}
