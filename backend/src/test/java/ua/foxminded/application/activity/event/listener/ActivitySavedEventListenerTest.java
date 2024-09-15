package ua.foxminded.application.activity.event.listener;

import com.github.benmanes.caffeine.cache.Cache;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.foxminded.domain.activity.model.event.ActivitySavedEvent;
import ua.foxminded.domain.pointsconfiguration.model.ManagerPointsConfiguration;
import ua.foxminded.domain.pointsconfiguration.service.ManagerPointsConfigurationService;
import ua.foxminded.domain.manager.model.entity.ManagerPoints;
import ua.foxminded.domain.manager.service.ManagerPointsService;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActivitySavedEventListenerTest {

    @Mock
    private Cache<String, Boolean> eventCacheMock;

    @Mock
    private ManagerPointsService managerPointsServiceMock;

    @Mock
    private ManagerPointsConfigurationService managerPointsConfigurationServiceMock;

    @InjectMocks
    private ActivitySavedEventListener listener;

    @Test
    public void shouldCreateNewManagerPoints_whenManagerPointsNotExist() {
        // Arrange
        ActivitySavedEvent event = new ActivitySavedEvent(1L); // Assuming event contains a manager ID of 1
        ManagerPointsConfiguration config = buildMockConfiguration();

        when(managerPointsConfigurationServiceMock.getConfiguration()).thenReturn(config);
        when(managerPointsServiceMock.findByManagerId(1L)).thenReturn(Collections.emptyList()); // No existing points

        // Act
        listener.handleEvent(event);

        // Assert
        ArgumentCaptor<ManagerPoints> captor = ArgumentCaptor.forClass(ManagerPoints.class);
        verify(managerPointsServiceMock).save(captor.capture());

        ManagerPoints savedManagerPoints = captor.getValue();
        assertEquals(1L, savedManagerPoints.getManagerId());
        assertEquals(LocalDate.now(), savedManagerPoints.getDate());
        assertEquals(1, savedManagerPoints.getActivitiesCount());
        assertEquals(config.getManagerPointsNormative(), savedManagerPoints.getNormative());
        assertTrue(savedManagerPoints.getPoints() > 0); // Ensure points are calculated
        assertTrue(savedManagerPoints.getBonuses() > 0); // Ensure bonus is applied
    }

    @Test
    public void shouldUpdateExistingManagerPoints_whenManagerPointsExist() {
        // Arrange
        ActivitySavedEvent event = new ActivitySavedEvent(1L);
        ManagerPointsConfiguration config = buildMockConfiguration();
        ManagerPoints existingManagerPoints = new ManagerPoints();
        existingManagerPoints.setManagerId(1L);
        existingManagerPoints.setActivitiesCount(5); // Manager has already completed 5 activities

        when(managerPointsConfigurationServiceMock.getConfiguration()).thenReturn(config);
        when(managerPointsServiceMock.findByManagerId(1L)).thenReturn(Collections.singletonList(existingManagerPoints));

        // Act
        listener.handleEvent(event);

        // Assert
        ArgumentCaptor<ManagerPoints> captor = ArgumentCaptor.forClass(ManagerPoints.class);
        verify(managerPointsServiceMock).save(captor.capture());

        ManagerPoints updatedManagerPoints = captor.getValue();
        assertEquals(6, updatedManagerPoints.getActivitiesCount()); // Activity count should increment
    }

    @Test
    public void shouldCalculateCorrectPoints() {
        // Arrange
        ActivitySavedEvent event = new ActivitySavedEvent(1L);
        ManagerPointsConfiguration config = buildMockConfiguration();
        ManagerPoints existingManagerPoints = new ManagerPoints();
        existingManagerPoints.setManagerId(1L);
        existingManagerPoints.setActivitiesCount(3);
        existingManagerPoints.setTestPeriodCount(1);
        existingManagerPoints.setBonuses(0);

        when(managerPointsConfigurationServiceMock.getConfiguration()).thenReturn(config);
        when(managerPointsServiceMock.findByManagerId(1L)).thenReturn(Collections.singletonList(existingManagerPoints));

        // Act
        listener.handleEvent(event);

        // Assert
        ArgumentCaptor<ManagerPoints> captor = ArgumentCaptor.forClass(ManagerPoints.class);
        verify(managerPointsServiceMock).save(captor.capture());

        ManagerPoints updatedManagerPoints = captor.getValue();
        int expectedPoints = 42;
        assertEquals(expectedPoints, updatedManagerPoints.getPoints());
    }

    private ManagerPointsConfiguration buildMockConfiguration() {
        ManagerPointsConfiguration config = new ManagerPointsConfiguration();
        config.setManagerPointsNormative(10);
        config.setManagerPointsCallCoefficient(5);
        config.setManagerPointsTestPeriodCoefficient(2);
        config.setManagerPointsBonusUnder3(20);
        config.setManagerPointsBonusEqual3(30);
        config.setManagerPointsBonusOver4(40);
        return config;
    }
}
