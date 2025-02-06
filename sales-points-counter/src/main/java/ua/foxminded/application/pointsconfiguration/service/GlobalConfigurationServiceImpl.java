package ua.foxminded.application.pointsconfiguration.service;

import org.springframework.stereotype.Service;
import ua.foxminded.domain.pointsconfiguration.model.entity.GlobalConfiguration;
import ua.foxminded.domain.pointsconfiguration.repository.GlobalConfigurationRepository;
import ua.foxminded.domain.pointsconfiguration.service.GlobalConfigurationService;

@Service
public class GlobalConfigurationServiceImpl implements GlobalConfigurationService {

    private final GlobalConfigurationRepository repository;

    public GlobalConfigurationServiceImpl(final GlobalConfigurationRepository repository) {
        this.repository = repository;
    }

    @Override
    public GlobalConfiguration save(final GlobalConfiguration configuration) {
        final GlobalConfiguration existingConfig = getConfiguration();
        configuration.setId(existingConfig.getId());
        return repository.save(configuration);
    }

    @Override
    public GlobalConfiguration getConfiguration() {
        return repository.findAll().getFirst();
    }
}
