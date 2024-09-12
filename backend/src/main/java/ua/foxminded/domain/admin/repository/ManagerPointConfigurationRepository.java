package ua.foxminded.domain.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.foxminded.domain.admin.model.ManagerPointsConfiguration;

import java.time.LocalDateTime;

@Repository
public interface ManagerPointConfigurationRepository extends JpaRepository<ManagerPointsConfiguration, Long> {

    ManagerPointsConfiguration findTop1ByCreatedDateLessThanEqualOrderByCreatedDateDesc(LocalDateTime today);

    ManagerPointsConfiguration findByCreatedDateBetween(LocalDateTime start, LocalDateTime end);

}