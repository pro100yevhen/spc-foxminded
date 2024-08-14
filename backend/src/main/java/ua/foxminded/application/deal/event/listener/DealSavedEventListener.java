package ua.foxminded.application.deal.event.listener;

import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.stereotype.Component;
import ua.foxminded.common.event.AbstractEventListener;
import ua.foxminded.domain.deal.model.event.DealSavedEvent;

@Component
public class DealSavedEventListener extends AbstractEventListener<DealSavedEvent> {

    protected DealSavedEventListener(final Cache<Integer, Boolean> eventCache) {
        super(eventCache);
    }

    @Override
    protected void handleEvent(final DealSavedEvent event) {

    }
}
