package ua.foxminded.domain.admin.service;

import ua.foxminded.domain.admin.model.ManagerPointsConfiguration;

import java.time.LocalDateTime;

public interface ManagerPointsConfigurationService {

    ManagerPointsConfiguration save(ManagerPointsConfiguration managerPointsConfiguration);

    ManagerPointsConfiguration getConfiguration();

    ManagerPointsConfiguration findByDate(LocalDateTime dateTime);
}
