package ua.foxminded.domain.pointsconfiguration.service;

import ua.foxminded.domain.pointsconfiguration.model.entity.ManagerPointsConfiguration;

public interface ManagerPointsConfigurationService {

    ManagerPointsConfiguration save(ManagerPointsConfiguration managerPointsConfiguration);

    ManagerPointsConfiguration getConfiguration(Long ownerId);
}
