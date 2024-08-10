package ua.foxminded.application.activity.service;

import org.springframework.stereotype.Service;
import ua.foxminded.domain.activity.model.entity.Activity;
import ua.foxminded.domain.activity.repository.ActivityRepository;
import ua.foxminded.domain.activity.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityServiceImpl (final ActivityRepository  activityRepository){
        this.activityRepository = activityRepository;

    }

    @Override
    public Activity save(final Activity activity) {
        return activityRepository.save(activity);
    }
}
