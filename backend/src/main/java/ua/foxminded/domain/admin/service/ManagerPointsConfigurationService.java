package ua.foxminded.domain.admin.service;

import ua.foxminded.domain.admin.model.ManagerPointsConfiguration;

public interface ManagerPointsConfigurationService {

    ManagerPointsConfiguration save(ManagerPointsConfiguration managerPointsConfiguration);

    ManagerPointsConfiguration getConfiguration();
}
