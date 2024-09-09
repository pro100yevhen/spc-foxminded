package ua.foxminded.common.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import ua.foxminded.common.event.model.BaseEvent;

@Component
public abstract class EventPublisher<T extends BaseEvent> {
    private static final Logger LOG = LoggerFactory.getLogger(EventPublisher.class);
    private final ApplicationEventPublisher applicationEventPublisher;

    public EventPublisher(final ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishEvent(final T event) {
        LOG.debug("Publishing event: {}", event);
        applicationEventPublisher.publishEvent(event);
    }
}