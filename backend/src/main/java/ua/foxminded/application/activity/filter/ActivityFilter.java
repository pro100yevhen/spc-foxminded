package ua.foxminded.application.activity.filter;

import org.springframework.stereotype.Component;
import ua.foxminded.common.filter.Filter;
import ua.foxminded.domain.activity.model.webhook.WebhookActivityModel;
import ua.foxminded.domain.pointsconfiguration.service.GlobalConfigurationService;
import ua.foxminded.domain.pointsconfiguration.service.ManagerPointsConfigurationService;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ActivityFilter implements Filter<WebhookActivityModel> {

    private final GlobalConfigurationService service;
    private final String ignoredPhrasePattern = "no answer from incoming call:";

    public ActivityFilter(final GlobalConfigurationService service) {
        this.service = service;
    }

    @Override
    public boolean apply(final WebhookActivityModel eventModel) {
        final Set<Long> allowedUserIds = parseIds(
                service.getConfiguration().getAllowedUserIds());

        return allowedUserIds.contains(eventModel.getData().getOwnerId()) &&
                eventModel.getData().isBusyFlag() &&
                eventModel.getData().isDone() &&
                !containsIgnoredPhrase(eventModel.getData().getSubject());
    }

    private boolean containsIgnoredPhrase(final String subject) {
        return subject != null && subject.toLowerCase().contains(ignoredPhrasePattern);
    }

    private Set<Long> parseIds(final String ids) {
        return Stream.of(ids.replaceAll("\\s+", "").split(","))
                .map(Long::parseLong)
                .collect(Collectors.toSet());
    }
}