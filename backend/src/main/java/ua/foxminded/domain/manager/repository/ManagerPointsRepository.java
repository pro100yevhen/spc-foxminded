package ua.foxminded.domain.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.foxminded.domain.manager.model.entity.ManagerPoints;

import java.time.LocalDate;
import java.util.List;

public interface ManagerPointsRepository extends JpaRepository<ManagerPoints, Long> {

    List<ManagerPoints> findByManagerIdAndDate(Long managerId, LocalDate date);

    List<ManagerPoints> findAllByDateBetween(LocalDate startDate, LocalDate endDate);

    List<ManagerPoints> findAllByDateBetweenAndManagerId(LocalDate startDate, LocalDate endDate, Long managerId);

    List<ManagerPoints> findByDate(LocalDate date);
}