package ua.foxminded.application.deal.event.listener;

import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.stereotype.Component;
import ua.foxminded.common.event.AbstractEventListener;
import ua.foxminded.domain.pointsconfiguration.model.entity.ManagerPointsConfiguration;
import ua.foxminded.domain.pointsconfiguration.service.ManagerPointsConfigurationService;
import ua.foxminded.domain.deal.model.event.DealDeletedEvent;
import ua.foxminded.domain.manager.model.entity.ManagerPoints;
import ua.foxminded.domain.manager.service.ManagerPointsService;

@Component
public class DealDeletedEventListener extends AbstractEventListener<DealDeletedEvent> {

    private final ManagerPointsService managerPointsService;
    private final ManagerPointsConfigurationService managerPointsConfigurationService;

    protected DealDeletedEventListener(final Cache<String, Boolean> eventCache,
                                       final ManagerPointsService managerPointsService,
                                       final ManagerPointsConfigurationService managerPointsConfigurationService) {
        super(eventCache);
        this.managerPointsService = managerPointsService;
        this.managerPointsConfigurationService = managerPointsConfigurationService;
    }

    @Override
    protected void handleConcreteEvent(final DealDeletedEvent event) {
        final ManagerPointsConfiguration config = managerPointsConfigurationService.findByDate(event.getUserId(),
                event.getCreatedDate());
        final Long managerId = event.getUserId();

        // Fetch existing points or create a new entry
        final ManagerPoints managerPoints = managerPointsService.findByManagerIdAndDate(managerId,
                event.getCreatedDate());

        // Decrease the test period count
        managerPoints.setTestPeriodCount(managerPoints.getTestPeriodCount() - 1);

        // Calculate bonuses and points
        final int bonus = getBonus(managerPoints.getTestPeriodCount(), config);
        managerPoints.setBonuses(bonus);

        final int points = calculatePoints(managerPoints, config);
        if (points <= 0) {
            managerPointsService.delete(managerPoints.getId());
        } else {
            managerPoints.setPoints(points);

            // Save updated manager points
            managerPointsService.save(managerPoints);
        }
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