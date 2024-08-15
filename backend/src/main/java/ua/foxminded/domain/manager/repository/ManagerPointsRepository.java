package ua.foxminded.domain.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.foxminded.domain.manager.model.ManagerPoints;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ManagerPointsRepository extends JpaRepository<ManagerPoints, Long>{ 
    List<ManagerPoints> findByManagerIdAndDate(Long managerId, LocalDate date);

    List<ManagerPoints> findAllByPeriod(LocalDate startDate, LocalDate endDate);

    List<ManagerPoints> findAllByPeriodAndManagerId(LocalDate startDate, LocalDate endDate, Long managerId);
}
