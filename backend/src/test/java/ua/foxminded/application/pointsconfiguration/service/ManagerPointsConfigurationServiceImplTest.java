//package ua.foxminded.application.pointsconfiguration.service;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import ua.foxminded.domain.pointsconfiguration.model.ManagerPointsConfiguration;
//import ua.foxminded.domain.pointsconfiguration.repository.ManagerPointConfigurationRepository;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class ManagerPointsConfigurationServiceImplTest {
//
//    @Mock
//    private ManagerPointConfigurationRepository managerPointConfigurationRepositoryMock;
//
//    @InjectMocks
//    private ManagerPointsConfigurationServiceImpl managerPointsConfigurationService;
//
//
//    private static final LocalDateTime START_OF_DAY = LocalDate.now().atStartOfDay();
//    private static final LocalDateTime END_OF_DAY = LocalDate.now().atTime(LocalTime.MAX);
//
//    @Test
//    public void shouldSaveManagerPointsConfiguration_whenSaveMethodCalled() {
//        // Arrange
//        ManagerPointsConfiguration config = new ManagerPointsConfiguration();
//        when(managerPointConfigurationRepositoryMock.save(config)).thenReturn(config);
//
//        // Act
//        ManagerPointsConfiguration savedConfig = managerPointsConfigurationService.save(config);
//
//        // Assert
//        assertNotNull(savedConfig);
//        verify(managerPointConfigurationRepositoryMock).save(config);
//    }
//
//    @Test
//    public void shouldReturnTodayConfiguration_whenExistsInRepository() {
//        // Arrange
//        ManagerPointsConfiguration todayConfig = new ManagerPointsConfiguration();
//        when(managerPointConfigurationRepositoryMock.findByCreatedDateBetween(START_OF_DAY, END_OF_DAY)).thenReturn(List.of(
//                todayConfig));
//
//        // Act
//        ManagerPointsConfiguration result = managerPointsConfigurationService.getConfiguration();
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(todayConfig, result);
//        verify(managerPointConfigurationRepositoryMock).findByCreatedDateBetween(START_OF_DAY, END_OF_DAY);
//    }
//
//    @Test
//    public void shouldReturnPreviousConfigurationAndSaveNew_whenNoTodayConfigExists() {
//        // Arrange
//        ManagerPointsConfiguration previousConfig = new ManagerPointsConfiguration();
//        when(managerPointConfigurationRepositoryMock.findByCreatedDateBetween(START_OF_DAY, END_OF_DAY)).thenReturn(
//                null);
//        when(managerPointConfigurationRepositoryMock.findTop1ByCreatedDateLessThanEqualOrderByCreatedDateDesc(
//                START_OF_DAY)).thenReturn(previousConfig);
//        when(managerPointConfigurationRepositoryMock.save(previousConfig)).thenReturn(previousConfig);
//
//        // Act
//        ManagerPointsConfiguration result = managerPointsConfigurationService.getConfiguration();
//
//        // Assert
//        assertNotNull(result);
//        verify(managerPointConfigurationRepositoryMock).findByCreatedDateBetween(START_OF_DAY, END_OF_DAY);
//        verify(managerPointConfigurationRepositoryMock).findTop1ByCreatedDateLessThanEqualOrderByCreatedDateDesc(
//                START_OF_DAY);
//        verify(managerPointConfigurationRepositoryMock).save(any(ManagerPointsConfiguration.class));
//    }
//
//    @Test
//    public void shouldCopyConfigurationForToday_whenSavingNewConfig() {
//        // Arrange
//        ManagerPointsConfiguration previousConfig = new ManagerPointsConfiguration();
//        previousConfig.setAllowedUserIds("1,2,3");
//        previousConfig.setDealStagesIds("10,11");
//        previousConfig.setManagerPointsNormative(100);
//        previousConfig.setManagerPointsCallCoefficient(2);
//        previousConfig.setManagerPointsTestPeriodCoefficient(3);
//        previousConfig.setManagerPointsBonusUnder3(10);
//        previousConfig.setManagerPointsBonusEqual3(20);
//        previousConfig.setManagerPointsBonusOver4(30);
//
//        when(managerPointConfigurationRepositoryMock.findByCreatedDateBetween(START_OF_DAY, END_OF_DAY)).thenReturn(
//                null);
//        when(managerPointConfigurationRepositoryMock.findTop1ByCreatedDateLessThanEqualOrderByCreatedDateDesc(
//                START_OF_DAY)).thenReturn(previousConfig);
//
//        ArgumentCaptor<ManagerPointsConfiguration> configCaptor = ArgumentCaptor.forClass(
//                ManagerPointsConfiguration.class);
//
//        // Act
//        managerPointsConfigurationService.getConfiguration();
//
//        // Assert
//        verify(managerPointConfigurationRepositoryMock).save(configCaptor.capture());
//        ManagerPointsConfiguration savedConfig = configCaptor.getValue();
//
//        assertEquals(previousConfig.getAllowedUserIds(), savedConfig.getAllowedUserIds());
//        assertEquals(previousConfig.getDealStagesIds(), savedConfig.getDealStagesIds());
//        assertEquals(previousConfig.getManagerPointsNormative(), savedConfig.getManagerPointsNormative());
//        assertEquals(previousConfig.getManagerPointsCallCoefficient(), savedConfig.getManagerPointsCallCoefficient());
//        assertEquals(previousConfig.getManagerPointsTestPeriodCoefficient(),
//                savedConfig.getManagerPointsTestPeriodCoefficient());
//        assertEquals(previousConfig.getManagerPointsBonusUnder3(), savedConfig.getManagerPointsBonusUnder3());
//        assertEquals(previousConfig.getManagerPointsBonusEqual3(), savedConfig.getManagerPointsBonusEqual3());
//        assertEquals(previousConfig.getManagerPointsBonusOver4(), savedConfig.getManagerPointsBonusOver4());
//    }
//
//    @Test
//    public void shouldReturnConfigurationByDate_whenFindByDateCalled() {
//        // Arrange
//        LocalDateTime targetDateTime = LocalDateTime.of(2024, 9, 10, 10, 0);
//        LocalDate targetDate = targetDateTime.toLocalDate();
//        LocalDateTime startOfTargetDay = targetDate.atStartOfDay();
//        LocalDateTime endOfTargetDay = targetDate.atTime(LocalTime.MAX);
//
//        ManagerPointsConfiguration config = new ManagerPointsConfiguration();
//        when(managerPointConfigurationRepositoryMock.findByCreatedDateBetween(startOfTargetDay,
//                endOfTargetDay)).thenReturn(List.of(config));
//
//        // Act
//        ManagerPointsConfiguration result = managerPointsConfigurationService.findByDate(targetDateTime);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(config, result);
//        verify(managerPointConfigurationRepositoryMock).findByCreatedDateBetween(startOfTargetDay, endOfTargetDay);
//    }
//}
