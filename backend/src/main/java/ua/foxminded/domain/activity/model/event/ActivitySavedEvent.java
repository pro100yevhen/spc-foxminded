package ua.foxminded.domain.activity.model.event;

import ua.foxminded.common.event.model.BaseEvent;

import java.util.Objects;

public class ActivitySavedEvent extends BaseEvent {

    private final Long userId;

    public ActivitySavedEvent(final Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        final ActivitySavedEvent that = (ActivitySavedEvent) o;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
