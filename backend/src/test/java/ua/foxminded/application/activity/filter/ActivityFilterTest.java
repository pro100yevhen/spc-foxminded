package ua.foxminded.application.activity.filter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.foxminded.domain.activity.model.webhook.ActivityDetailsModel;
import ua.foxminded.domain.activity.model.webhook.WebhookActivityModel;
import ua.foxminded.domain.pointsconfiguration.model.ManagerPointsConfiguration;
import ua.foxminded.domain.pointsconfiguration.service.ManagerPointsConfigurationService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ActivityFilterTest {

    private static final String IGNORED_REFERENCE_TYPE = "salesphone";
    private static final String OTHER_REFERENCE_TYPE = "other";
    private static final String ALLOWED_USER_IDS = "1,2,3";
    private static final Long ALLOWED_USER_ID = 1L;
    private static final Long NOT_ALLOWED_USER_ID = 4L;
    private static final String MARKED_AS_DONE_TIME_TODAY = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    private static final String MARKED_AS_DONE_TIME_PAST = "2024-09-10 10:30:00";

    @Mock
    private ManagerPointsConfigurationService managerPointsConfigurationServiceMock;
    @InjectMocks
    private ActivityFilter activityFilter;

    @Test
    public void shouldReturnFalse_whenUserIdNotAllowed() {
        // Arrange
        ManagerPointsConfiguration config = new ManagerPointsConfiguration();
        config.setAllowedUserIds(ALLOWED_USER_IDS);
        when(managerPointsConfigurationServiceMock.getConfiguration()).thenReturn(config);

        WebhookActivityModel eventModel = buildWebhookActivityModel(NOT_ALLOWED_USER_ID, true, true, MARKED_AS_DONE_TIME_TODAY, OTHER_REFERENCE_TYPE);

        // Act
        boolean result = activityFilter.apply(eventModel);

        // Assert
        assertFalse(result);
    }

    @Test
    public void shouldReturnFalse_whenBusyFlagIsFalse() {
        // Arrange
        ManagerPointsConfiguration config = new ManagerPointsConfiguration();
        config.setAllowedUserIds(ALLOWED_USER_IDS);
        when(managerPointsConfigurationServiceMock.getConfiguration()).thenReturn(config);

        WebhookActivityModel eventModel = buildWebhookActivityModel(ALLOWED_USER_ID, false, true, MARKED_AS_DONE_TIME_TODAY, OTHER_REFERENCE_TYPE);

        // Act
        boolean result = activityFilter.apply(eventModel);

        // Assert
        assertFalse(result);
    }

    @Test
    public void shouldReturnFalse_whenDoneIsFalse() {
        // Arrange
        ManagerPointsConfiguration config = new ManagerPointsConfiguration();
        config.setAllowedUserIds(ALLOWED_USER_IDS);
        when(managerPointsConfigurationServiceMock.getConfiguration()).thenReturn(config);

        WebhookActivityModel eventModel = buildWebhookActivityModel(ALLOWED_USER_ID, true, false, MARKED_AS_DONE_TIME_TODAY, OTHER_REFERENCE_TYPE);

        // Act
        boolean result = activityFilter.apply(eventModel);

        // Assert
        assertFalse(result);
    }

    @Test
    public void shouldReturnFalse_whenReferenceTypeIsIgnored() {
        // Arrange
        ManagerPointsConfiguration config = new ManagerPointsConfiguration();
        config.setAllowedUserIds(ALLOWED_USER_IDS);
        when(managerPointsConfigurationServiceMock.getConfiguration()).thenReturn(config);

        WebhookActivityModel eventModel = buildWebhookActivityModel(ALLOWED_USER_ID, true, true, MARKED_AS_DONE_TIME_TODAY, IGNORED_REFERENCE_TYPE);

        // Act
        boolean result = activityFilter.apply(eventModel);

        // Assert
        assertFalse(result);
    }

    @Test
    public void shouldReturnFalse_whenMarkedAsDoneNotToday() {
        // Arrange
        ManagerPointsConfiguration config = new ManagerPointsConfiguration();
        config.setAllowedUserIds(ALLOWED_USER_IDS);
        when(managerPointsConfigurationServiceMock.getConfiguration()).thenReturn(config);

        WebhookActivityModel eventModel = buildWebhookActivityModel(ALLOWED_USER_ID, true, true, MARKED_AS_DONE_TIME_PAST, OTHER_REFERENCE_TYPE);

        // Act
        boolean result = activityFilter.apply(eventModel);

        // Assert
        assertFalse(result);
    }

    @Test
    public void shouldReturnTrue_whenAllConditionsMet() {
        // Arrange
        ManagerPointsConfiguration config = new ManagerPointsConfiguration();
        config.setAllowedUserIds(ALLOWED_USER_IDS);
        when(managerPointsConfigurationServiceMock.getConfiguration()).thenReturn(config);

        WebhookActivityModel eventModel = buildWebhookActivityModel(ALLOWED_USER_ID, true, true, MARKED_AS_DONE_TIME_TODAY, OTHER_REFERENCE_TYPE);

        // Act
        boolean result = activityFilter.apply(eventModel);

        // Assert
        assertTrue(result);
    }

    private WebhookActivityModel buildWebhookActivityModel(Long assignedToUserId, boolean busyFlag, boolean done, String markedAsDoneTime, String referenceType) {
        ActivityDetailsModel current = new ActivityDetailsModel();
        current.setAssignedToUserId(assignedToUserId);
        current.setBusyFlag(busyFlag);
        current.setDone(done);
        current.setMarkedAsDoneTime(markedAsDoneTime);
        current.setReferenceType(referenceType);

        WebhookActivityModel eventModel = new WebhookActivityModel();
        eventModel.setCurrent(current);

        return eventModel;
    }
}