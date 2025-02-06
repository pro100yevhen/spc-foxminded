package ua.foxminded.application.manager.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.foxminded.domain.manager.model.entity.ManagerPoints;
import ua.foxminded.domain.manager.repository.ManagerPointsRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ManagerPointsServiceImplTest {

    private static final Long MANAGER_ID = 1L;
    private static final LocalDate START_DATE = LocalDate.of(2024, 1, 1);
    private static final LocalDate END_DATE = LocalDate.of(2024, 1, 31);
    private static final LocalDate TODAY = LocalDate.now();
    private static final LocalDateTime DATE_TIME = LocalDateTime.of(2024, 9, 14, 23, 59, 59);
    private static final ManagerPoints MANAGER_POINTS = new ManagerPoints();

    @Mock
    private ManagerPointsRepository managerPointsRepository;

    @InjectMocks
    private ManagerPointsServiceImpl managerPointsService;


    @Test
    public void shouldSaveManagerPoints() {
        // Arrange
        when(managerPointsRepository.save(MANAGER_POINTS)).thenReturn(MANAGER_POINTS);

        // Act
        ManagerPoints result = managerPointsService.save(MANAGER_POINTS);

        // Assert
        assertEquals(MANAGER_POINTS, result);
        verify(managerPointsRepository).save(MANAGER_POINTS);
    }

    @Test
    public void shouldFindByManagerId_whenManagerPointsExist() {
        // Arrange
        List<ManagerPoints> expectedPoints = Arrays.asList(MANAGER_POINTS);
        when(managerPointsRepository.findByManagerIdAndDate(MANAGER_ID, TODAY)).thenReturn(expectedPoints);

        // Act
        List<ManagerPoints> result = managerPointsService.findByManagerId(MANAGER_ID);

        // Assert
        assertEquals(expectedPoints, result);
        verify(managerPointsRepository).findByManagerIdAndDate(MANAGER_ID, TODAY);
    }

    @Test
    public void shouldFindAllByDateBetween_whenPointsExist() {
        // Arrange
        List<ManagerPoints> expectedPoints = Arrays.asList(MANAGER_POINTS);
        when(managerPointsRepository.findAllByDateBetween(START_DATE, END_DATE)).thenReturn(expectedPoints);

        // Act
        List<ManagerPoints> result = managerPointsService.findAllByDateBetween(START_DATE, END_DATE);

        // Assert
        assertEquals(expectedPoints, result);
        verify(managerPointsRepository).findAllByDateBetween(START_DATE, END_DATE);
    }

    @Test
    public void shouldFindAllByDateBetweenAndManagerId_whenPointsExist() {
        // Arrange
        List<ManagerPoints> expectedPoints = Arrays.asList(MANAGER_POINTS);
        when(managerPointsRepository.findAllByDateBetweenAndManagerId(START_DATE, END_DATE, MANAGER_ID)).thenReturn(
                expectedPoints);

        // Act
        List<ManagerPoints> result = managerPointsService.findAllByDateBetweenAndManagerId(START_DATE, END_DATE,
                MANAGER_ID);

        // Assert
        assertEquals(expectedPoints, result);
        verify(managerPointsRepository).findAllByDateBetweenAndManagerId(START_DATE, END_DATE, MANAGER_ID);
    }

    @Test
    public void shouldFindAllForToday_whenPointsExist() {
        // Arrange
        List<ManagerPoints> expectedPoints = Arrays.asList(MANAGER_POINTS);
        when(managerPointsRepository.findByDate(TODAY)).thenReturn(expectedPoints);

        // Act
        List<ManagerPoints> result = managerPointsService.findAllForToday();

        // Assert
        assertEquals(expectedPoints, result);
        verify(managerPointsRepository).findByDate(TODAY);
    }

    @Test
    public void shouldDeleteManagerPoints_whenPointsExist() {
        // Arrange
        Long id = 1L;

        // Act
        managerPointsService.delete(id);

        // Assert
        verify(managerPointsRepository).deleteById(id);
    }

    @Test
    public void shouldFindByManagerIdAndDate_whenPointsExistForDate() {
        // Arrange
        LocalDateTime startOfDay = DATE_TIME.toLocalDate().atStartOfDay();
        LocalDateTime endOfDay = DATE_TIME.toLocalDate().atTime(LocalTime.MAX);
        when(managerPointsRepository.findByManagerIdAndCreatedDateBetween(MANAGER_ID, startOfDay, endOfDay)).thenReturn(
                MANAGER_POINTS);

        // Act
        ManagerPoints result = managerPointsService.findByManagerIdAndDate(MANAGER_ID, DATE_TIME);

        // Assert
        assertEquals(MANAGER_POINTS, result);
        verify(managerPointsRepository).findByManagerIdAndCreatedDateBetween(MANAGER_ID, startOfDay, endOfDay);
    }
}