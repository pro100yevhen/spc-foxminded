package ua.foxminded.application.pointsconfiguration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ua.foxminded.domain.pointsconfiguration.model.entity.ManagerPointsConfiguration;
import ua.foxminded.domain.pointsconfiguration.repository.ManagerPointConfigurationRepository;
import ua.foxminded.domain.pointsconfiguration.service.ManagerPointsConfigurationService;

import java.util.List;

@Service
public class ManagerPointsConfigurationServiceImpl implements ManagerPointsConfigurationService {

    private static final Logger LOG = LoggerFactory.getLogger(ManagerPointsConfigurationServiceImpl.class);

    private final ManagerPointConfigurationRepository managerPointConfigurationRepository;

    public ManagerPointsConfigurationServiceImpl(
            final ManagerPointConfigurationRepository managerPointConfigurationRepository) {
        this.managerPointConfigurationRepository = managerPointConfigurationRepository;
    }

    @Override
    public ManagerPointsConfiguration save(final ManagerPointsConfiguration managerPointsConfiguration) {
        return managerPointConfigurationRepository.save(managerPointsConfiguration);
    }

    @Override
    public ManagerPointsConfiguration getConfiguration(final Long ownerId) {
        // Find configuration for the given owner
        final List<ManagerPointsConfiguration> todayConfigs =
                managerPointConfigurationRepository.findByOwnerId(ownerId);

        if (!todayConfigs.isEmpty()) {
            if (todayConfigs.size() > 1) {
                LOG.warn("Multiple configurations found for today. Removing extra configurations.");
                for (int i = 1; i < todayConfigs.size(); i++) {
                    managerPointConfigurationRepository.delete(todayConfigs.get(i));
                }
            }
            return todayConfigs.get(0);
        }

        // If no config found, get the latest config from any manager
        final ManagerPointsConfiguration latestConfig =
                managerPointConfigurationRepository.findTopByOrderByCreatedDateDesc();

        LOG.info("Creating a new configuration for owner {} based on the latest existing configuration.", ownerId);

        final ManagerPointsConfiguration newConfig = copyConfiguration(latestConfig, ownerId);
        return managerPointConfigurationRepository.save(newConfig);
    }

    private ManagerPointsConfiguration copyConfiguration(final ManagerPointsConfiguration oldConfig, final Long ownerId) {
        final ManagerPointsConfiguration newConfig = new ManagerPointsConfiguration();
        newConfig.setOwnerId(ownerId);
        newConfig.setManagerPointsNormative(oldConfig.getManagerPointsNormative());
        newConfig.setManagerPointsCallCoefficient(oldConfig.getManagerPointsCallCoefficient());
        newConfig.setManagerPointsTestPeriodCoefficient(oldConfig.getManagerPointsTestPeriodCoefficient());
        newConfig.setManagerPointsBonusUnder3(oldConfig.getManagerPointsBonusUnder3());
        newConfig.setManagerPointsBonusEqual3(oldConfig.getManagerPointsBonusEqual3());
        newConfig.setManagerPointsBonusOver4(oldConfig.getManagerPointsBonusOver4());
        return newConfig;
    }
}