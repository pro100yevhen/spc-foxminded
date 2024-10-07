package ua.foxminded.common.event;

import com.github.benmanes.caffeine.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.core.ResolvableType;
import ua.foxminded.common.event.model.BaseEvent;

import static java.util.Objects.isNull;

public abstract class AbstractEventListener<T extends BaseEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractEventListener.class);

    protected final Cache<String, Boolean> eventCache;

    protected AbstractEventListener(final Cache<String, Boolean> eventCache) {
        this.eventCache = eventCache;
    }

    @EventListener
    public final void handleEvent(final T event) {

        if (isNull(getGenericType()) || !event.getClass().isAssignableFrom(getGenericType())) {
            return;
        }

        LOG.info("In handleConcreteEvent: Handling {}", event.getClass().getSimpleName());

        if (eventCache.getIfPresent(event.getEventId()) != null) {
            return;
        }

        try {
            handleConcreteEvent(event);
            eventCache.put(event.getEventId(), true);
        } catch (final Exception exception) {

            LOG.error("Error handling event with ID {} of type {}. Error: {}", event.getEventId(), event.getClass().getSimpleName(), exception.getMessage());

        }
    }

    protected abstract void handleConcreteEvent(T event);

    private Class<?> getGenericType() {
        try {
            return ResolvableType.forClass(this.getClass())
                    .as(AbstractEventListener.class)
                    .getGeneric(0)
                    .resolve();
        } catch (final Exception e) {
            LOG.error("Failed to resolve generic type for {}: {}", this.getClass().getSimpleName(), e.getMessage());
            return null;
        }
    }
}