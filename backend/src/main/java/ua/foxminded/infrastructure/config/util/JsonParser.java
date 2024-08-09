package ua.foxminded.infrastructure.config.util;

import ua.foxminded.common.exception.JsonParsingException;

public interface JsonParser {

    <T> T parseJson(String json, Class<T> targetClass) throws JsonParsingException;
}
