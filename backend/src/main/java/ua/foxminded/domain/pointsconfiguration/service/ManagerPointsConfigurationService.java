package ua.foxminded.domain.pointsconfiguration.service;

import ua.foxminded.domain.pointsconfiguration.model.ManagerPointsConfiguration;

import java.time.LocalDateTime;

public interface ManagerPointsConfigurationService {

    ManagerPointsConfiguration save(ManagerPointsConfiguration managerPointsConfiguration);

    ManagerPointsConfiguration getConfiguration();

    ManagerPointsConfiguration findByDate(LocalDateTime dateTime);
}
