package ua.foxminded.infrastructure.util.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import ua.foxminded.common.exception.JsonParsingException;
import ua.foxminded.infrastructure.util.JsonParser;

@Component
public class JacksonJsonParserImpl implements JsonParser {

    private final ObjectMapper mapper;

    public JacksonJsonParserImpl(final ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public <T> T parseJson(final String json, final Class<T> targetClz) {
        try {
            return mapper.readValue(json, targetClz);
        } catch (final JsonProcessingException e) {
            throw new JsonParsingException(e, "Fail to parse json string:[%s] to object of type [%s]", json, targetClz);
        }
    }
}