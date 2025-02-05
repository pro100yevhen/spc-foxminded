package ua.foxminded.application.pointsconfiguration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ua.foxminded.domain.pointsconfiguration.model.entity.ManagerPointsConfiguration;
import ua.foxminded.domain.pointsconfiguration.repository.ManagerPointConfigurationRepository;
import ua.foxminded.domain.pointsconfiguration.service.ManagerPointsConfigurationService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
        final LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
        final LocalDateTime endOfDay = LocalDate.now().atTime(LocalTime.MAX);

        // Find today's configuration for the given owner
        final List<ManagerPointsConfiguration> todayConfigs =
                managerPointConfigurationRepository.findByOwnerIdAndCreatedDateBetween(ownerId, startOfDay, endOfDay);

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

        final ManagerPointsConfiguration newConfig = copyConfigurationForToday(latestConfig, ownerId);
        return managerPointConfigurationRepository.save(newConfig);
    }

    @Override
    public ManagerPointsConfiguration findByDate(final Long ownerId, final LocalDateTime dateTime) {
        final LocalDate date = dateTime.toLocalDate();
        final LocalDateTime startOfDay = date.atStartOfDay();
        final LocalDateTime endOfDay = date.atTime(LocalTime.MAX);

        final List<ManagerPointsConfiguration> configs =
                managerPointConfigurationRepository.findByOwnerIdAndCreatedDateBetween(ownerId, startOfDay, endOfDay);

        if (configs.size() > 1) {
            LOG.warn("Multiple configurations found for date {}. Removing extra configurations.", date);
            for (int i = 1; i < configs.size(); i++) {
                managerPointConfigurationRepository.delete(configs.get(i));
                LOG.debug("Deleted configuration: {}", configs.get(i));
            }
        }

        return configs.get(0);
    }

    private ManagerPointsConfiguration copyConfigurationForToday(final ManagerPointsConfiguration oldConfig, final Long ownerId) {
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