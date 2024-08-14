package ua.foxminded.application.activity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.foxminded.common.model.entity.Owner;
import ua.foxminded.domain.activity.model.entity.Activity;
import ua.foxminded.domain.activity.repository.ActivityRepository;
import ua.foxminded.common.repository.OwnerRepository;
import ua.foxminded.domain.activity.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;
    private final OwnerRepository ownerRepository;

    @Autowired
    public ActivityServiceImpl(final ActivityRepository activityRepository, final OwnerRepository ownerRepository) {
        this.activityRepository = activityRepository;
        this.ownerRepository = ownerRepository;
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
        return activityRepository.save(activity);
    }
}
