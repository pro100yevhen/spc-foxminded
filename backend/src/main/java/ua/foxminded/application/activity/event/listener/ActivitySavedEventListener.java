package ua.foxminded.application.activity.event.listener;

import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.stereotype.Component;
import ua.foxminded.common.event.AbstractEventListener;
import ua.foxminded.domain.activity.model.event.ActivitySavedEvent;

@Component
public class ActivitySavedEventListener extends AbstractEventListener<ActivitySavedEvent> {

    protected ActivitySavedEventListener(final Cache<Integer, Boolean> eventCache) {
        super(eventCache);
    }

    @Override
    protected void handleEvent(final ActivitySavedEvent event) {

    }
}
