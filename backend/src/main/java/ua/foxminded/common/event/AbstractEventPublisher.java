package ua.foxminded.common.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import ua.foxminded.common.event.model.BaseEvent;

@Component
public abstract class AbstractEventPublisher<T extends BaseEvent> {
    private final ApplicationEventPublisher applicationEventPublisher;

    protected AbstractEventPublisher(final ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishEvent(final T event) {
        applicationEventPublisher.publishEvent(event);
    }
}