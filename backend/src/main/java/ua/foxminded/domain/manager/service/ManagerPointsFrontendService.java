package ua.foxminded.domain.manager.service;

import ua.foxminded.common.model.dto.OwnerDto;
import ua.foxminded.domain.manager.model.dto.ManagerPointsDto;

import java.time.LocalDate;
import java.util.List;

public interface ManagerPointsFrontendService {

    List<ManagerPointsDto> findAllForToday();

    List<ManagerPointsDto> getPointsByPeriod(LocalDate startDate, LocalDate endDate);

    List<ManagerPointsDto> getPointsByManagerAndPeriod(Long managerId, LocalDate startDate, LocalDate endDate);

    List<OwnerDto> getAllManagers();

    List<ManagerPointsDto> getAverageProgressPerMonth(LocalDate startDate, LocalDate endDate);
}