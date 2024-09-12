package ua.foxminded.domain.activity.model.event;

import ua.foxminded.common.event.model.BaseEvent;

import java.time.LocalDateTime;
import java.util.Objects;

public class ActivityDeletedEvent extends BaseEvent {

    private final Long userId;

    private final LocalDateTime createdDate;

    public ActivityDeletedEvent(final Long userId, final LocalDateTime createdDate) {
        this.userId = userId;
        this.createdDate = createdDate;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        final ActivityDeletedEvent that = (ActivityDeletedEvent) o;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
