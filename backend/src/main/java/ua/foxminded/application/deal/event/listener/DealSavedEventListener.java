package ua.foxminded.application.deal.event.listener;

import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.stereotype.Component;
import ua.foxminded.application.manager.service.ManagerPointsServiceImpl;
import ua.foxminded.domain.deal.model.event.DealSavedEvent;
import ua.foxminded.domain.manager.model.entity.ManagerPoints;
import ua.foxminded.infrastructure.config.ManagerPointsConfig;
import ua.foxminded.common.event.AbstractEventListener;

import java.time.LocalDate;

@Component
public class DealSavedEventListener extends AbstractEventListener<DealSavedEvent> {

    private final ManagerPointsServiceImpl managerPointsService;
    private final ManagerPointsConfig config;

    protected DealSavedEventListener(final Cache<Integer, Boolean> eventCache,
                                     final ManagerPointsServiceImpl managerPointsService,
                                     final ManagerPointsConfig config) {
        super(eventCache);
        this.managerPointsService = managerPointsService;
        this.config = config;
    }

    @Override
    protected void handleEvent(final DealSavedEvent event) {
        final Long managerId = event.getUserId();

        // Fetch existing points or create a new entry
        final ManagerPoints managerPoints = managerPointsService.findByManagerId(managerId)
                .stream()
                .findFirst()
                .orElseGet(() -> new ManagerPoints());

        managerPoints.setManagerId(managerId);
        managerPoints.setDate(LocalDate.now());
        managerPoints.setTestPeriodCount(managerPoints.getTestPeriodCount() + 1);

        // Calculate bonuses and points
        final int bonus = getBonus(managerPoints.getTestPeriodCount());
        managerPoints.setBonuses(bonus);

        final int points = calculatePoints(managerPoints);
        managerPoints.setPoints(points);

        // Save updated manager points
        managerPointsService.save(managerPoints);
    }

    private int calculatePoints(final ManagerPoints managerPoints) {
        final int activitiesCount = managerPoints.getActivitiesCount();
        final int testPeriodCount = managerPoints.getTestPeriodCount();

        final int bonus = managerPoints.getBonuses();
        final int intensity = activitiesCount * config.getCallCoefficient() +
                testPeriodCount * config.getTestPeriodCoefficient() +
                bonus;

        return intensity;
    }

    private int getBonus(final int testPeriodCount) {
        if (testPeriodCount < 3) {
            return config.getBonusUnder3();
        } else if (testPeriodCount == 3) {
            return config.getBonusEqual3();
        } else {
            return config.getBonusOver4();
        }
    }
}