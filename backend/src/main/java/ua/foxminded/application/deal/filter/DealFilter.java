package ua.foxminded.application.deal.filter;

import org.springframework.stereotype.Component;
import ua.foxminded.common.filter.Filter;
import ua.foxminded.domain.pointsconfiguration.service.GlobalConfigurationService;
import ua.foxminded.domain.deal.model.webhook.WebhookDealModel;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DealFilter implements Filter<WebhookDealModel> {

    private final GlobalConfigurationService service;
    private final String status = "open";

    public DealFilter(final GlobalConfigurationService service) {
        this.service = service;
    }

    @Override
    public boolean apply(final WebhookDealModel eventModel) {
        final Set<Long> allowedUserIds = parseIds(service.getConfiguration().getAllowedUserIds());
        final Set<Long> allowedDealStages = parseIds(service.getConfiguration().getDealStagesIds());

        return allowedDealStages.contains(eventModel.getData().getStageId()) &&
                allowedUserIds.contains(eventModel.getData().getOwnerId()) &&
                eventModel.getData().getStatus().equals(status);
    }

    private Set<Long> parseIds(final String ids) {
        return Stream.of(ids.replaceAll("\\s+", "").split(","))
                .map(Long::parseLong)
                .collect(Collectors.toSet());
    }
}