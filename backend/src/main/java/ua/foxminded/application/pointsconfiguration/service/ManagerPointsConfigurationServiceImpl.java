package ua.foxminded.application.pointsconfiguration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ua.foxminded.domain.pointsconfiguration.model.ManagerPointsConfiguration;
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
    public ManagerPointsConfiguration getConfiguration() {
        final LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
        final LocalDateTime endOfDay = LocalDate.now().atTime(LocalTime.MAX);

        // Get all configurations for today
        final List<ManagerPointsConfiguration> todayConfigs = managerPointConfigurationRepository.findByCreatedDateBetween(startOfDay, endOfDay);

        if (!todayConfigs.isEmpty()) {
            // If multiple configurations are found, log a warning and remove extras
            if (todayConfigs.size() > 1) {
                LOG.warn("Multiple configurations found for today. Removing extra configurations.");
                for (int i = 1; i < todayConfigs.size(); i++) {
                    managerPointConfigurationRepository.delete(todayConfigs.get(i)); // Delete extra configurations
                }
            }
            return todayConfigs.get(0); // Return the first one
        }

        // No configuration for today, get the most recent configuration
        final ManagerPointsConfiguration previousConfig = managerPointConfigurationRepository.findTop1ByCreatedDateLessThanEqualOrderByCreatedDateDesc(startOfDay);
            // Copy the latest configuration to save it for today
            final ManagerPointsConfiguration newConfig = copyConfigurationForToday(previousConfig);
            return managerPointConfigurationRepository.save(newConfig);
    }

    @Override
    public ManagerPointsConfiguration findByDate(final LocalDateTime dateTime) {
        final LocalDate date = dateTime.toLocalDate();
        final LocalDateTime startOfDay = date.atStartOfDay();
        final LocalDateTime endOfDay = date.atTime(LocalTime.MAX);

        // Get all configurations for the given date
        final List<ManagerPointsConfiguration> configs = managerPointConfigurationRepository.findByCreatedDateBetween(startOfDay, endOfDay);

        // Handle multiple configurations
        if (configs.size() > 1) {
            LOG.warn("Multiple configurations found for date {}. Removing extra configurations.", date);

            // Remove extra configurations
            for (int i = 1; i < configs.size(); i++) {
                managerPointConfigurationRepository.delete(configs.get(i)); // Delete extra configurations
                LOG.debug("Deleted configuration: {}", configs.get(i));
            }
        }

        return configs.get(0); // Return the first one
    }

    private ManagerPointsConfiguration copyConfigurationForToday(final ManagerPointsConfiguration oldConfig) {
        final ManagerPointsConfiguration newConfig = new ManagerPointsConfiguration();
        newConfig.setAllowedUserIds(oldConfig.getAllowedUserIds());
        newConfig.setDealStagesIds(oldConfig.getDealStagesIds());
        newConfig.setManagerPointsNormative(oldConfig.getManagerPointsNormative());
        newConfig.setManagerPointsCallCoefficient(oldConfig.getManagerPointsCallCoefficient());
        newConfig.setManagerPointsTestPeriodCoefficient(oldConfig.getManagerPointsTestPeriodCoefficient());
        newConfig.setManagerPointsBonusUnder3(oldConfig.getManagerPointsBonusUnder3());
        newConfig.setManagerPointsBonusEqual3(oldConfig.getManagerPointsBonusEqual3());
        newConfig.setManagerPointsBonusOver4(oldConfig.getManagerPointsBonusOver4());

        return newConfig;
    }
}