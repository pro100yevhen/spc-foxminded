package ua.foxminded.application.activity.event.listener;

import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.stereotype.Component;
import ua.foxminded.common.event.AbstractEventListener;
import ua.foxminded.domain.activity.model.event.ActivitySavedEvent;
import ua.foxminded.domain.admin.model.ManagerPointsConfiguration;
import ua.foxminded.domain.admin.service.ManagerPointsConfigurationService;
import ua.foxminded.domain.manager.model.entity.ManagerPoints;
import ua.foxminded.domain.manager.service.ManagerPointsService;

import java.time.LocalDate;

@Component
public class ActivitySavedEventListener extends AbstractEventListener<ActivitySavedEvent> {

    private final ManagerPointsService managerPointsService;
    private final ManagerPointsConfigurationService managerPointsConfigurationService;

    protected ActivitySavedEventListener(final Cache<Integer, Boolean> eventCache,
                                         final ManagerPointsService managerPointsService,
                                         final ManagerPointsConfigurationService managerPointsConfigurationService) {
        super(eventCache);
        this.managerPointsService = managerPointsService;
        this.managerPointsConfigurationService = managerPointsConfigurationService;
    }

    @Override
    protected void handleEvent(final ActivitySavedEvent event) {
        final ManagerPointsConfiguration config = managerPointsConfigurationService.getConfiguration();
        final Long managerId = event.getUserId();

        // Fetch existing points or create a new entry
        final ManagerPoints managerPoints = managerPointsService.findByManagerId(managerId)
                .stream()
                .findFirst()
                .orElseGet(() -> new ManagerPoints());

        managerPoints.setManagerId(managerId);
        managerPoints.setDate(LocalDate.now());
        managerPoints.setActivitiesCount(managerPoints.getActivitiesCount() + 1);

        // Calculate bonuses and points
        final int bonus = getBonus(managerPoints.getTestPeriodCount(), config);
        managerPoints.setBonuses(bonus);

        final int points = calculatePoints(managerPoints, config);
        managerPoints.setPoints(points);
        managerPoints.setNormative(config.getManagerPointsNormative());

        // Save updated manager points
        managerPointsService.save(managerPoints);
    }

    private int calculatePoints(final ManagerPoints managerPoints, final ManagerPointsConfiguration config) {
        final int activitiesCount = managerPoints.getActivitiesCount();
        final int testPeriodCount = managerPoints.getTestPeriodCount();

        final int bonus = managerPoints.getBonuses();
        final int intensity = activitiesCount * config.getManagerPointsCallCoefficient() +
                testPeriodCount * config.getManagerPointsTestPeriodCoefficient() +
                bonus;

        return intensity;
    }

    private int getBonus(final int testPeriodCount, final ManagerPointsConfiguration config) {
        if (testPeriodCount < 3) {
            return config.getManagerPointsBonusUnder3();
        } else if (testPeriodCount == 3) {
            return config.getManagerPointsBonusEqual3();
        } else {
            return config.getManagerPointsBonusOver4();
        }
    }
}