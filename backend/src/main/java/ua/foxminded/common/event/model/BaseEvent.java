package ua.foxminded.common.event.model;

import java.util.Objects;
import java.util.UUID;

public abstract class BaseEvent {

    private final String eventId;

    public BaseEvent() {
        this.eventId = UUID.randomUUID().toString();
    }

    public String getEventId() {
        return eventId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final BaseEvent baseEvent = (BaseEvent) o;
        return Objects.equals(eventId, baseEvent.eventId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId);
    }
}