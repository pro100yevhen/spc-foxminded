package ua.foxminded.application.deal.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ua.foxminded.common.filter.Filter;
import ua.foxminded.domain.deal.model.webhook.WebhookDealModel;

import java.util.List;

@Component
public class DealFilter implements Filter<WebhookDealModel> {

    private final List<Long> dealsStagesIds;
    private final List<Long> allowedUserIds;

    public DealFilter(@Value("${app.deals-stages-ids}") final List<Long> dealsStagesIds,
                      @Value("${app.allowed-user-ids}") final List<Long> allowedUserIds) {
        this.dealsStagesIds = dealsStagesIds;
        this.allowedUserIds = allowedUserIds;
    }

    @Override
    public boolean apply(final WebhookDealModel eventModel) {
        final Long stageId = eventModel.getCurrent().getStageId();
        final Long userId = eventModel.getCurrent().getUserId();
        return dealsStagesIds.contains(stageId) && allowedUserIds.contains(userId);
    }
}
