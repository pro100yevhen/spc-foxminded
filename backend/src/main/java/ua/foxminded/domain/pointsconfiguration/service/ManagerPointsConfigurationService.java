package ua.foxminded.domain.pointsconfiguration.service;

import ua.foxminded.domain.pointsconfiguration.model.entity.ManagerPointsConfiguration;

import java.time.LocalDateTime;

public interface ManagerPointsConfigurationService {

    ManagerPointsConfiguration save(ManagerPointsConfiguration managerPointsConfiguration);

    ManagerPointsConfiguration getConfiguration(Long ownerId);

    ManagerPointsConfiguration findByDate(Long ownerId, LocalDateTime dateTime);
}
