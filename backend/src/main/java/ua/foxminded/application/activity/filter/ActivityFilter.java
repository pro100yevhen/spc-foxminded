package ua.foxminded.application.activity.filter;

import org.springframework.stereotype.Component;
import ua.foxminded.common.filter.Filter;
import ua.foxminded.domain.activity.model.webhook.WebhookActivityModel;
import ua.foxminded.domain.admin.service.ManagerPointsConfigurationService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.time.format.DateTimeFormatter;

@Component
public class ActivityFilter implements Filter<WebhookActivityModel> {

    private final ManagerPointsConfigurationService managerPointsConfigurationService;
    private final String ignoredReferenceType = "salesphone";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public ActivityFilter(final ManagerPointsConfigurationService managerPointsConfigurationService) {
        this.managerPointsConfigurationService = managerPointsConfigurationService;
    }

    @Override
    public boolean apply(final WebhookActivityModel eventModel) {
        final Set<Long> allowedUserIds = parseIds(
                managerPointsConfigurationService.getConfiguration().getAllowedUserIds());
        // Check if markedAsDoneTime is today
        final boolean isMarkedAsDoneToday = isMarkedAsDoneToday(eventModel.getCurrent().getMarkedAsDoneTime());

        return allowedUserIds.contains(eventModel.getCurrent().getAssignedToUserId()) &&
                eventModel.getCurrent().isBusyFlag() &&
                eventModel.getCurrent().isDone() &&
                !ignoredReferenceType.equalsIgnoreCase(eventModel.getCurrent().getReferenceType()) &&
                isMarkedAsDoneToday;  // Add the filter condition here
    }

    private Set<Long> parseIds(final String ids) {
        return Stream.of(ids.replaceAll("\\s+", "").split(","))
                .map(Long::parseLong)
                .collect(Collectors.toSet());
    }

    private boolean isMarkedAsDoneToday(final String markedAsDoneTime) {
        if (markedAsDoneTime == null || markedAsDoneTime.isEmpty()) {
            return false;
        }
        // Parse markedAsDoneTime to LocalDateTime
        final LocalDateTime doneTime = LocalDateTime.parse(markedAsDoneTime, formatter);
        // Compare if the date part of doneTime is today
        return doneTime.toLocalDate().isEqual(LocalDate.now());
    }
}