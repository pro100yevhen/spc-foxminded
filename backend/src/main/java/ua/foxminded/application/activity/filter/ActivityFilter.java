package ua.foxminded.application.activity.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ua.foxminded.common.filter.Filter;
import ua.foxminded.domain.activity.model.event.WebhookActivityEventModel;

import java.util.List;

@Component
public class ActivityFilter implements Filter<WebhookActivityEventModel> {

    private final List<Long> allowedUserIds;

    public ActivityFilter(@Value("${app.allowed-user-ids}") final List<Long> allowedUserIds) {
        this.allowedUserIds = allowedUserIds;
    }

    @Override
    public boolean apply(final WebhookActivityEventModel eventModel) {
        final Long userId = eventModel.getCurrent().getUserId();
        final boolean busyFlag = eventModel.getCurrent().isBusyFlag();
        return allowedUserIds.contains(userId) && busyFlag;
    }
}
