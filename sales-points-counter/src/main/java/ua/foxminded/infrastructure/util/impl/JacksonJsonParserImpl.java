package ua.foxminded.infrastructure.util.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ua.foxminded.common.exception.JsonParsingException;
import ua.foxminded.infrastructure.util.JsonParser;

@Component
public class JacksonJsonParserImpl implements JsonParser {

    private static final Logger LOG = LoggerFactory.getLogger(JacksonJsonParserImpl.class);

    private final ObjectMapper mapper;

    public JacksonJsonParserImpl(final ObjectMapper mapper) {
        this.mapper = mapper;
        this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // Ignore unknown properties

        this.mapper.registerModule(new JavaTimeModule());
        this.mapper.disable(com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    }

    @Override
    public <T> T parseJson(final String json, final Class<T> targetClz) {
        LOG.info("Attempting to parse JSON string to object of type: {}", targetClz.getSimpleName());
        try {
            final T parsedObject = mapper.readValue(json, targetClz);
            LOG.info("Successfully parsed JSON to object");
            return parsedObject;
        } catch (final JsonProcessingException e) {
            LOG.error("Failed to parse JSON string: [{}] to object of type [{}]", json, targetClz.getSimpleName(), e);
            throw new JsonParsingException(e, "Failed to parse json string:[%s] to object of type [%s]", json,
                    targetClz);
        }
    }
}