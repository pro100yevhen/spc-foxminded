package ua.foxminded.domain.pointsconfiguration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.foxminded.domain.pointsconfiguration.model.entity.ManagerPointsConfiguration;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ManagerPointConfigurationRepository extends JpaRepository<ManagerPointsConfiguration, Long> {

    List<ManagerPointsConfiguration> findByOwnerIdAndCreatedDateBetween(Long ownerId, LocalDateTime start, LocalDateTime end);

    ManagerPointsConfiguration findTopByOrderByCreatedDateDesc();
}