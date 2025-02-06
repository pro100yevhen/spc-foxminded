package ua.foxminded.domain.deal.model.event;

import ua.foxminded.common.event.model.BaseEvent;

import java.time.LocalDateTime;
import java.util.Objects;

public class DealDeletedEvent extends BaseEvent {

    private final Long userId;

    private final LocalDateTime createdDate;

    public DealDeletedEvent(final Long userId, final LocalDateTime createdDate) {
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

        final DealDeletedEvent that = (DealDeletedEvent) o;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
