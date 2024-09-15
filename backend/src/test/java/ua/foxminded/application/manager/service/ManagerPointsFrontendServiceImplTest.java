package ua.foxminded.application.manager.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import ua.foxminded.application.manager.controller.ManagerPointsRecourse;
import ua.foxminded.infrastructure.mapper.TypeMapperFacade;
import ua.foxminded.common.model.dto.OwnerDto;
import ua.foxminded.common.model.entity.Owner;
import ua.foxminded.common.repository.OwnerRepository;
import ua.foxminded.domain.manager.model.dto.ManagerPointsDto;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ManagerPointsFrontendServiceImplTest {

    private static final Long MANAGER_ID = 1L;
    private static final LocalDate START_DATE = LocalDate.of(2024, 1, 1);
    private static final LocalDate END_DATE = LocalDate.of(2024, 1, 31);
    private static final ManagerPointsDto MANAGER_POINTS_DTO = new ManagerPointsDto();
    private static final List<ManagerPointsDto> MANAGER_POINTS_LIST = Arrays.asList(MANAGER_POINTS_DTO);
    private static final List<Owner> EXPECTED_MANAGERS = Arrays.asList(new Owner());
    private static final List<OwnerDto> EXPECTED_MANAGERS_DTO = Collections.singletonList(new OwnerDto());

    @Mock
    private ManagerPointsRecourse recourse;

    @Mock
    private OwnerRepository ownerRepository;

    @Mock
    private TypeMapperFacade typeMapperFacade;

    @InjectMocks
    private ManagerPointsFrontendServiceImpl managerPointsFrontendService;

    @Test
    public void shouldFindAllForToday_whenPointsExist() {
        // Arrange
        ResponseEntity<List<ManagerPointsDto>> responseEntity = ResponseEntity.of(Optional.of(MANAGER_POINTS_LIST));
        when(recourse.getPointsForToday()).thenReturn(responseEntity);

        // Act
        List<ManagerPointsDto> result = managerPointsFrontendService.findAllForToday();

        // Assert
        assertEquals(MANAGER_POINTS_LIST, result);
        verify(recourse).getPointsForToday();
    }

    @Test
    public void shouldGetPointsByPeriod_whenPointsExist() {
        // Arrange
        ResponseEntity<List<ManagerPointsDto>> responseEntity = ResponseEntity.of(Optional.of(MANAGER_POINTS_LIST));
        when(recourse.getAllPointsByPeriod(START_DATE, END_DATE)).thenReturn(responseEntity);

        // Act
        List<ManagerPointsDto> result = managerPointsFrontendService.getPointsByPeriod(START_DATE, END_DATE);

        // Assert
        assertEquals(MANAGER_POINTS_LIST, result);
        verify(recourse).getAllPointsByPeriod(START_DATE, END_DATE);
    }

    @Test
    public void shouldGetPointsByManagerAndPeriod_whenPointsExist() {
        // Arrange
        ResponseEntity<List<ManagerPointsDto>> responseEntity = ResponseEntity.of(Optional.of(MANAGER_POINTS_LIST));
        when(recourse.getPointsByManagerIdAndPeriod(MANAGER_ID, START_DATE, END_DATE)).thenReturn(responseEntity);

        // Act
        List<ManagerPointsDto> result = managerPointsFrontendService.getPointsByManagerAndPeriod(MANAGER_ID, START_DATE, END_DATE);

        // Assert
        assertEquals(MANAGER_POINTS_LIST, result);
        verify(recourse).getPointsByManagerIdAndPeriod(MANAGER_ID, START_DATE, END_DATE);
    }

    @Test
    public void shouldGetAllManagers_whenManagersExist() {
        // Arrange
        when(ownerRepository.findAll()).thenReturn(EXPECTED_MANAGERS);
        when(typeMapperFacade.mapList(EXPECTED_MANAGERS, OwnerDto.class)).thenReturn(EXPECTED_MANAGERS_DTO);

        // Act
        List<OwnerDto> result = managerPointsFrontendService.getAllManagers();

        // Assert
        assertEquals(EXPECTED_MANAGERS_DTO, result);
        verify(ownerRepository).findAll();
        verify(typeMapperFacade).mapList(EXPECTED_MANAGERS, OwnerDto.class);
    }
}