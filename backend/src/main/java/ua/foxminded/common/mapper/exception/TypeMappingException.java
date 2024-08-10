package ua.foxminded.common.mapper.exception;

import ua.foxminded.common.exception.PipedriveApplicationException;

import static java.lang.String.format;

public class TypeMappingException extends PipedriveApplicationException {

    public TypeMappingException(final String msgTemplate, final Object... args) {
        super(format(msgTemplate, args));
    }

    public TypeMappingException(final Throwable cause, final String msgTemplate, final Object... args) {
        super(format(msgTemplate, args), cause);
    }
}
