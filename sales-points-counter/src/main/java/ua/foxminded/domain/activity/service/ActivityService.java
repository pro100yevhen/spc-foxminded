package ua.foxminded.domain.activity.service;

import ua.foxminded.domain.activity.model.entity.Activity;

import java.time.LocalDate;
import java.util.List;

public interface ActivityService {

    Activity save(Activity activity);

    List<Activity> findByOwnerAndDate(Long ownerId, LocalDate date);

    void delete(Long id);
}
