package ua.foxminded.application.deal.filter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.foxminded.domain.pointsconfiguration.model.ManagerPointsConfiguration;
import ua.foxminded.domain.pointsconfiguration.service.ManagerPointsConfigurationService;
import ua.foxminded.domain.deal.model.webhook.DealDetailsModel;
import ua.foxminded.domain.deal.model.webhook.WebhookDealModel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DealFilterTest {

    private final static String DEAL_OPEN_STATUS = "open";
    private final static String DEAL_CLOSED_STATUS = "closed";
    private final static String ALLOWED_USER_IDS = "1, 2, 3";
    private final static String ALLOWED_DEAL_STAGE_IDS = "10, 11, 12";
    private final static Long ALLOWED_STAGE_ID= 10L;
    private final static Long ALLOWED_USER_ID = 1L;
    private final static Long NOT_ALLOWED_STAGE_ID = 13L;

    @Mock
    private ManagerPointsConfigurationService managerPointsConfigurationServiceMock;

    @InjectMocks
    private DealFilter dealFilter;

    @Test
    public void shouldReturnFalse_whenStageIdNotAllowed() {
        // Arrange
        ManagerPointsConfiguration config = new ManagerPointsConfiguration();
        config.setAllowedUserIds(ALLOWED_USER_IDS);
        config.setDealStagesIds(ALLOWED_DEAL_STAGE_IDS);
        when(managerPointsConfigurationServiceMock.getConfiguration()).thenReturn(config);

        WebhookDealModel eventModel = buildWebhookDealModel(ALLOWED_USER_ID, NOT_ALLOWED_STAGE_ID, DEAL_OPEN_STATUS);

        // Act
        boolean result = dealFilter.apply(eventModel);

        // Assert
        assertFalse(result);
    }

    @Test
    public void shouldReturnFalse_whenUserIdNotAllowed() {
        // Arrange
        final String notAllowedUserIds = "4,5,6";
        ManagerPointsConfiguration config = new ManagerPointsConfiguration();
        config.setAllowedUserIds(notAllowedUserIds);
        config.setDealStagesIds(ALLOWED_DEAL_STAGE_IDS);
        when(managerPointsConfigurationServiceMock.getConfiguration()).thenReturn(config);

        WebhookDealModel eventModel = buildWebhookDealModel(ALLOWED_USER_ID, ALLOWED_STAGE_ID, DEAL_OPEN_STATUS);

        // Act
        boolean result = dealFilter.apply(eventModel);

        // Assert
        assertFalse(result);
    }

    @Test
    public void shouldReturnFalse_whenStatusIsNotOpen() {
        // Arrange
        ManagerPointsConfiguration config = new ManagerPointsConfiguration();
        config.setAllowedUserIds(ALLOWED_USER_IDS);
        config.setDealStagesIds(ALLOWED_DEAL_STAGE_IDS);
        when(managerPointsConfigurationServiceMock.getConfiguration()).thenReturn(config);

        WebhookDealModel eventModel = buildWebhookDealModel(ALLOWED_USER_ID, ALLOWED_STAGE_ID, DEAL_CLOSED_STATUS);

        // Act
        boolean result = dealFilter.apply(eventModel);

        // Assert
        assertFalse(result);
    }

    @Test
    public void shouldReturnTrue_whenAllConditionsMet() {
        // Arrange
        ManagerPointsConfiguration config = new ManagerPointsConfiguration();
        config.setAllowedUserIds(ALLOWED_USER_IDS);
        config.setDealStagesIds(ALLOWED_DEAL_STAGE_IDS);
        when(managerPointsConfigurationServiceMock.getConfiguration()).thenReturn(config);

        WebhookDealModel eventModel = buildWebhookDealModel(ALLOWED_USER_ID, ALLOWED_STAGE_ID, DEAL_OPEN_STATUS);

        // Act
        boolean result = dealFilter.apply(eventModel);

        // Assert
        assertTrue(result);
    }

    @Test
    public void shouldParseIdsCorrectly_whenIdsStringContainsSpaces() {
        // Arrange
        ManagerPointsConfiguration config = new ManagerPointsConfiguration();
        config.setAllowedUserIds(ALLOWED_USER_IDS);
        config.setDealStagesIds(ALLOWED_DEAL_STAGE_IDS);
        when(managerPointsConfigurationServiceMock.getConfiguration()).thenReturn(config);

        WebhookDealModel eventModel = buildWebhookDealModel(ALLOWED_USER_ID, ALLOWED_STAGE_ID, DEAL_OPEN_STATUS);

        // Act
        boolean result = dealFilter.apply(eventModel);

        // Assert
        assertTrue(result);
    }

    private WebhookDealModel buildWebhookDealModel(Long userId, Long stageId, String status) {
        DealDetailsModel current = new DealDetailsModel();
        current.setUserId(userId);
        current.setStageId(stageId);
        current.setStatus(status);

        WebhookDealModel eventModel = new WebhookDealModel();
        eventModel.setCurrent(current);

        return eventModel;
    }
}