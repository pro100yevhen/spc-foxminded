package ua.foxminded.application.admin.service;

import org.springframework.stereotype.Service;
import ua.foxminded.domain.admin.model.ManagerPointsConfiguration;
import ua.foxminded.domain.admin.repository.ManagerPointConfigurationRepository;
import ua.foxminded.domain.admin.service.ManagerPointsConfigurationService;

import java.util.List;

@Service
public class ManagerPointsConfigurationServiceImpl implements ManagerPointsConfigurationService {

    private final int CONFIGURATIONS_MAX_SISE = 1;

    private final ManagerPointConfigurationRepository managerPointConfigurationRepository;

    public ManagerPointsConfigurationServiceImpl(final ManagerPointConfigurationRepository managerPointConfigurationRepository) {
        this.managerPointConfigurationRepository = managerPointConfigurationRepository;
    }

    @Override
    public ManagerPointsConfiguration save(final ManagerPointsConfiguration managerPointsConfiguration) {
        return managerPointConfigurationRepository.save(managerPointsConfiguration);
    }

    @Override
    public ManagerPointsConfiguration getConfiguration() {
        final List<ManagerPointsConfiguration> managerPointSettings = managerPointConfigurationRepository.findAll();

        if (managerPointSettings.size() > CONFIGURATIONS_MAX_SISE) {
            removeAnotherConfiguration(managerPointSettings);
        }

        return managerPointSettings.getFirst();
    }

    private void removeAnotherConfiguration(final List<ManagerPointsConfiguration> managerPointSettings) {
        for (int i = CONFIGURATIONS_MAX_SISE; i < managerPointSettings.size(); i++) {
            managerPointConfigurationRepository.deleteById(managerPointSettings.get(i).getId());
        }
    }
}
