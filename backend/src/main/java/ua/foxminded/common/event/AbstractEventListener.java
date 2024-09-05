package ua.foxminded.common.event;

import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ua.foxminded.common.event.model.BaseEvent;

@Component
public abstract class AbstractEventListener<T extends BaseEvent> {

    protected final Cache<Integer, Boolean> eventCache;

    protected AbstractEventListener(final Cache<Integer, Boolean> eventCache) {
        this.eventCache = eventCache;
    }

    @EventListener
    protected void handleConcreteEvent(final T event) {
        final int eventHashCode = event.hashCode();
        if (eventCache.getIfPresent(eventHashCode) != null) {
            return;
        }
            handleEvent(event);
            eventCache.put(eventHashCode, true);

    }

    protected abstract void handleEvent(T event);
}