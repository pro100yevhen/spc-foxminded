package ua.foxminded.common.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import ua.foxminded.common.event.model.BaseEvent;

@Component
public class GenericEventPublisher extends AbstractEventPublisher {
    private static final Logger LOG = LoggerFactory.getLogger(GenericEventPublisher.class);

    public GenericEventPublisher(final ApplicationEventPublisher applicationEventPublisher) {
        super(applicationEventPublisher);
    }

    @Override
    public void publishEvent(final BaseEvent event) {
        LOG.debug("Publishing event: {}", event);
        super.publishEvent(event);
    }
}