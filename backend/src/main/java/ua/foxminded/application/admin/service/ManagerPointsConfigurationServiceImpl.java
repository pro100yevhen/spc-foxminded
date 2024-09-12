package ua.foxminded.application.admin.service;

import org.springframework.stereotype.Service;
import ua.foxminded.domain.admin.model.ManagerPointsConfiguration;
import ua.foxminded.domain.admin.repository.ManagerPointConfigurationRepository;
import ua.foxminded.domain.admin.service.ManagerPointsConfigurationService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class ManagerPointsConfigurationServiceImpl implements ManagerPointsConfigurationService {

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

        // Check if there's already a configuration for today
        final ManagerPointsConfiguration todayConfig = managerPointConfigurationRepository.findByCreatedDateBetween(
                startOfDay, endOfDay);

        if (todayConfig != null) {
            // Configuration for today exists, return it
            return todayConfig;
        }

        // No configuration for today, get the most recent configuration
        final ManagerPointsConfiguration previousConfig = managerPointConfigurationRepository.findTop1ByCreatedDateLessThanEqualOrderByCreatedDateDesc(
                startOfDay);

        // Copy the latest configuration to save it for today
        final ManagerPointsConfiguration newConfig = copyConfigurationForToday(previousConfig);
        return managerPointConfigurationRepository.save(newConfig);
    }

    @Override
    public ManagerPointsConfiguration findByDate(final LocalDateTime dateTime) {
        final LocalDate date = dateTime.toLocalDate();
        final LocalDateTime startOfDay = date.atStartOfDay();
        final LocalDateTime endOfDay = date.atTime(LocalTime.MAX);
        return managerPointConfigurationRepository.findByCreatedDateBetween(startOfDay, endOfDay);
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