package ua.foxminded.application.activity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.foxminded.common.event.GenericEventPublisher;
import ua.foxminded.common.model.entity.Owner;
import ua.foxminded.domain.activity.model.entity.Activity;
import ua.foxminded.domain.activity.model.event.ActivitySavedEvent;
import ua.foxminded.domain.activity.repository.ActivityRepository;
import ua.foxminded.common.repository.OwnerRepository;
import ua.foxminded.domain.activity.service.ActivityService;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;
    private final OwnerRepository ownerRepository;
    private final GenericEventPublisher eventPublisher;

    @Autowired
    public ActivityServiceImpl(final ActivityRepository activityRepository, final OwnerRepository ownerRepository,
                               final GenericEventPublisher eventPublisher) {
        this.activityRepository = activityRepository;
        this.ownerRepository = ownerRepository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public Activity save(final Activity activity) {
        checkOwner(activity.getOwner());

        // Get today's date range (midnight to midnight)
        final LocalDateTime now = LocalDateTime.now();
        final LocalDateTime todayStart = now.toLocalDate().atStartOfDay();
        final LocalDateTime todayEnd = todayStart.plusDays(1).minusNanos(1);

        // Check if an activity with the same person ID exists today
        final Activity existingActivity = activityRepository.findByPersonIdAndCreatedDateBetween(activity.getPersonId(),
                todayStart, todayEnd);

        if (existingActivity != null) {
            // If an activity exists for today, return the existing one
            return existingActivity;
        } else {
            // If not, save the new activity and publish an event
            final Activity savedActivity = activityRepository.save(activity);
            publishEvent(savedActivity);
            return savedActivity;
        }
    }

    private void checkOwner(final Owner owner) {
        if (owner != null && owner.getId() != null) {
            final Optional<Owner> existingOwner = ownerRepository.findById(owner.getId());
            if (existingOwner.isPresent()) {
            } else {
                ownerRepository.save(owner);
            }
        }
    }

    private void publishEvent(final Activity activity) {
        eventPublisher.publishEvent(new ActivitySavedEvent(activity.getOwner().getId()));
    }
}