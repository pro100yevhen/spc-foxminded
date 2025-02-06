package ua.foxminded.domain.pointsconfiguration.service;

import ua.foxminded.domain.pointsconfiguration.model.entity.GlobalConfiguration;

public interface GlobalConfigurationService {

    GlobalConfiguration save(GlobalConfiguration configuration);

    GlobalConfiguration getConfiguration();

}
