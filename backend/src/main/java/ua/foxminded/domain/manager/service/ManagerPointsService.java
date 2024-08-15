package ua.foxminded.domain.manager.service;

import ua.foxminded.domain.manager.model.ManagerPoints;

import java.time.LocalDate;
import java.util.List;

public interface ManagerPointsService {

    ManagerPoints save(ManagerPoints managerPoints);

    List<ManagerPoints> findByManagerIdAndDate(Long managerId, LocalDate date);

    List<ManagerPoints> findAllByPeriod(LocalDate startDate, LocalDate endDate);

    List<ManagerPoints> findAllByPeriodAndManagerId(LocalDate startDate, LocalDate endDate, Long managerId);
}
