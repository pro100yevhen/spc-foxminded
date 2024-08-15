package ua.foxminded.application.deal.event.listener;

import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.stereotype.Component;
import ua.foxminded.application.manager.service.ManagerPointsServiceImpl;
import ua.foxminded.domain.deal.model.event.DealSavedEvent;
import ua.foxminded.domain.manager.model.ManagerPoints;
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
        final LocalDate date = LocalDate.now();

        // Fetch existing points or create a new entry
        final ManagerPoints managerPoints = managerPointsService.findByManagerIdAndDate(managerId, date)
                .stream()
                .findFirst()
                .orElseGet(() -> new ManagerPoints());

        managerPoints.setManagerId(managerId);
        managerPoints.setDate(date);
        managerPoints.setTestPeriodCount(managerPoints.getTestPeriodCount() + 1);

        final int points = calculatePoints(managerPoints);
        managerPoints.setPoints(points);

        managerPointsService.save(managerPoints);
    }

    private int calculatePoints(final ManagerPoints managerPoints) {
        final int activitiesCount = managerPoints.getActivitiesCount();
        final int testPeriodCount = managerPoints.getTestPeriodCount();

        final int bonus = getBonus(testPeriodCount);
        final int intensity = activitiesCount * config.getCallCoefficient() +
                testPeriodCount * config.getTestPeriodCoefficient() +
                bonus;

        return Math.min(intensity, config.getNorm());
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