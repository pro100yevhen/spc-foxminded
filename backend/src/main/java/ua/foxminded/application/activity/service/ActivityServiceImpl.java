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
        // Check if the owner exists
        final Owner owner = activity.getOwner();
        if (owner != null && owner.getId() != null) {
            final Owner existingOwner = ownerRepository.findById(owner.getId()).orElse(null);
            if (existingOwner != null) {
                // Use the existing owner
                activity.setOwner(existingOwner);
            } else {
                // Save new owner
                ownerRepository.save(owner);
            }
        }

        // Check if the same activity already exists in the database
        final Optional<Activity> existingActivity = activityRepository.findById(activity.getId());

        if (existingActivity.isPresent()) {
            // If activity exists, skip saving and return the existing one
            return existingActivity.get();
        } else {
            // If not, save the new activity and publish an event
            final Activity savedActivity = activityRepository.save(activity);
            eventPublisher.publishEvent(new ActivitySavedEvent(savedActivity.getOwner().getId()));
            return savedActivity;
        }
    }
}