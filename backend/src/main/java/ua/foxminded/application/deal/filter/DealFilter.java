package ua.foxminded.application.deal.filter;

import org.springframework.stereotype.Component;
import ua.foxminded.common.filter.Filter;
import ua.foxminded.domain.admin.service.ManagerPointsConfigurationService;
import ua.foxminded.domain.deal.model.webhook.WebhookDealModel;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DealFilter implements Filter<WebhookDealModel> {

    private final ManagerPointsConfigurationService managerPointsConfigurationService;

    public DealFilter(final ManagerPointsConfigurationService managerPointsConfigurationService) {
        this.managerPointsConfigurationService = managerPointsConfigurationService;
    }

    @Override
    public boolean apply(final WebhookDealModel eventModel) {
        final Set<Long> allowedUserIds = parseIds(managerPointsConfigurationService.getConfiguration().getAllowedUserIds());
        final Set<Long> allowedDealStages = parseIds(managerPointsConfigurationService.getConfiguration().getDealStagesIds());

        return allowedDealStages.contains(eventModel.getCurrent().getStageId()) &&
                allowedUserIds.contains(eventModel.getCurrent().getUserId());
    }

    private Set<Long> parseIds(final String ids) {
        return Stream.of(ids.replaceAll("\\s+", "").split(","))
                .map(Long::parseLong)
                .collect(Collectors.toSet());
    }
}