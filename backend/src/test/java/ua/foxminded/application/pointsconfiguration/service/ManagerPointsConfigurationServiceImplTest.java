package ua.foxminded.application.pointsconfiguration.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.foxminded.domain.pointsconfiguration.model.entity.ManagerPointsConfiguration;
import ua.foxminded.domain.pointsconfiguration.repository.ManagerPointConfigurationRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ManagerPointsConfigurationServiceImplTest {

    @Mock
    private ManagerPointConfigurationRepository managerPointConfigurationRepositoryMock;

    @InjectMocks
    private ManagerPointsConfigurationServiceImpl managerPointsConfigurationService;

    private static final LocalDateTime START_OF_DAY = LocalDate.now().atStartOfDay();
    private static final LocalDateTime END_OF_DAY = LocalDate.now().atTime(LocalTime.MAX);
    private static final Long OWNER_ID = 1L;

    @Test
    public void shouldSaveManagerPointsConfiguration_whenSaveMethodCalled() {
        // Arrange
        ManagerPointsConfiguration config = new ManagerPointsConfiguration();
        when(managerPointConfigurationRepositoryMock.save(config)).thenReturn(config);

        // Act
        ManagerPointsConfiguration savedConfig = managerPointsConfigurationService.save(config);

        // Assert
        assertNotNull(savedConfig);
        verify(managerPointConfigurationRepositoryMock).save(config);
    }

    @Test
    public void shouldReturnTodayConfiguration_whenExistsInRepository() {
        // Arrange
        ManagerPointsConfiguration todayConfig = new ManagerPointsConfiguration();
        when(managerPointConfigurationRepositoryMock.findByOwnerIdAndCreatedDateBetween(OWNER_ID, START_OF_DAY,
                END_OF_DAY))
                .thenReturn(List.of(todayConfig));

        // Act
        ManagerPointsConfiguration result = managerPointsConfigurationService.getConfiguration(OWNER_ID);

        // Assert
        assertNotNull(result);
        assertEquals(todayConfig, result);
        verify(managerPointConfigurationRepositoryMock).findByOwnerIdAndCreatedDateBetween(OWNER_ID, START_OF_DAY,
                END_OF_DAY);
    }

    @Test
    public void shouldReturnConfigurationByDate_whenFindByDateCalled() {
        // Arrange
        LocalDateTime targetDateTime = LocalDateTime.of(2024, 9, 10, 10, 0);
        LocalDate targetDate = targetDateTime.toLocalDate();
        LocalDateTime startOfTargetDay = targetDate.atStartOfDay();
        LocalDateTime endOfTargetDay = targetDate.atTime(LocalTime.MAX);

        ManagerPointsConfiguration config = new ManagerPointsConfiguration();
        when(managerPointConfigurationRepositoryMock.findByOwnerIdAndCreatedDateBetween(OWNER_ID, startOfTargetDay,
                endOfTargetDay))
                .thenReturn(List.of(config));

        // Act
        ManagerPointsConfiguration result = managerPointsConfigurationService.getConfiguration(OWNER_ID);

        // Assert
        assertNotNull(result);
        assertEquals(config, result);
        verify(managerPointConfigurationRepositoryMock).findByOwnerIdAndCreatedDateBetween(OWNER_ID, startOfTargetDay,
                endOfTargetDay);
    }
}