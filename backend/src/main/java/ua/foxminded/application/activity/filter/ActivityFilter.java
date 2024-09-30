package ua.foxminded.application.activity.filter;

import org.springframework.stereotype.Component;
import ua.foxminded.common.filter.Filter;
import ua.foxminded.domain.activity.model.webhook.WebhookActivityModel;
import ua.foxminded.domain.pointsconfiguration.service.ManagerPointsConfigurationService;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ActivityFilter implements Filter<WebhookActivityModel> {

    private final ManagerPointsConfigurationService managerPointsConfigurationService;
    private final String ignoredReferenceType = "salesphone";

    public ActivityFilter(final ManagerPointsConfigurationService managerPointsConfigurationService) {
        this.managerPointsConfigurationService = managerPointsConfigurationService;
    }

    @Override
    public boolean apply(final WebhookActivityModel eventModel) {
        final Set<Long> allowedUserIds = parseIds(
                managerPointsConfigurationService.getConfiguration().getAllowedUserIds());

        return allowedUserIds.contains(eventModel.getData().getOwnerId()) &&
                eventModel.getData().isBusyFlag() &&
                eventModel.getData().isDone() &&
                !ignoredReferenceType.equalsIgnoreCase(eventModel.getData().getType());
    }

    private Set<Long> parseIds(final String ids) {
        return Stream.of(ids.replaceAll("\\s+", "").split(","))
                .map(Long::parseLong)
                .collect(Collectors.toSet());
    }
}