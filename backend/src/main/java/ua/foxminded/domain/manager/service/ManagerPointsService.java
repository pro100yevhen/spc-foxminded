package ua.foxminded.domain.manager.service;

import ua.foxminded.domain.manager.model.entity.ManagerPoints;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ManagerPointsService {

    ManagerPoints save(ManagerPoints managerPoints);

    List<ManagerPoints> findByManagerId(Long managerId);

    List<ManagerPoints> findAllByDateBetween(LocalDate startDate, LocalDate endDate);

    List<ManagerPoints> findAllByDateBetweenAndManagerId(LocalDate startDate, LocalDate endDate, Long managerId);

    List<ManagerPoints> findAllForToday();

    void delete(Long id);

    ManagerPoints findByManagerIdAndDate(Long managerId, LocalDateTime date);
}
