package ua.foxminded.domain.pointsconfiguration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.foxminded.domain.pointsconfiguration.model.entity.GlobalConfiguration;

@Repository
public interface GlobalConfigurationRepository extends JpaRepository<GlobalConfiguration, Long> {
}
