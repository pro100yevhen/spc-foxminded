package ua.foxminded.application.activity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.foxminded.application.pipedriveapi.service.PipedriveApiClient;
import ua.foxminded.common.event.EventPublisher;
import ua.foxminded.common.model.entity.Owner;
import ua.foxminded.common.repository.OwnerRepository;
import ua.foxminded.domain.activity.model.entity.Activity;
import ua.foxminded.domain.activity.model.event.ActivityDeletedEvent;
import ua.foxminded.domain.activity.model.event.ActivitySavedEvent;
import ua.foxminded.domain.activity.repository.ActivityRepository;
import ua.foxminded.domain.activity.service.ActivityService;
import ua.foxminded.domain.pipedriveapi.model.ActivityPipedriveApi;
import ua.foxminded.infrastructure.config.TimezoneProvider;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;
    private final OwnerRepository ownerRepository;
    private final EventPublisher eventPublisher;
    private final PipedriveApiClient apiClient;
    private TimezoneProvider timezoneProvider;

    @Autowired
    public ActivityServiceImpl(final ActivityRepository activityRepository, final OwnerRepository ownerRepository,
                               final EventPublisher eventPublisher, final PipedriveApiClient apiClient,
                               final TimezoneProvider timezoneProvider) {
        this.activityRepository = activityRepository;
        this.ownerRepository = ownerRepository;
        this.eventPublisher = eventPublisher;
        this.apiClient = apiClient;
        this.timezoneProvider = timezoneProvider;
    }

    @Override
    public Activity save(final Activity activity) {
        final ActivityPipedriveApi activityFromApi = apiClient.getActivityById(activity.getId()).block();
        addDataToActivity(activity, activityFromApi);
        checkOwner(activity.getOwner());

        // Get today's date range (midnight to midnight)
        final LocalDate today = LocalDate.now();
        final LocalDateTime todayStart = today.atStartOfDay();
        final LocalDateTime todayEnd = today.atTime(LocalTime.MAX);

        // Return the new activity if the 'MarkedAsDoneTime' is not today
        if (!isMarkedAsDoneToday(activity, today)) {
            return activity;
        }

        final Activity existingActivity = activityRepository.findByPersonIdAndCreatedDateBetween(activity.getPersonId(),
                todayStart, todayEnd);

        if(existingActivity != null){
            return existingActivity;
        }else{
            return saveNewActivity(activity);
        }
    }

    @Override
    public List<Activity> findByOwnerAndDate(final Long ownerId, final LocalDate date) {
        final LocalDateTime startDateTime = date.atStartOfDay();
        final LocalDateTime endDateTime = date.atTime(LocalTime.MAX);
        return activityRepository.findAllByOwnerIdAndMarkedAsDoneTimeBetween(ownerId, startDateTime, endDateTime);
    }

    @Override
    public void delete(final Long id) {
        final Activity activity = activityRepository.findById(id).get();
        activityRepository.deleteById(id);
        eventPublisher.publishEvent(new ActivityDeletedEvent(activity.getOwner().getId(), activity.getCreatedDate()));
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

    private void addDataToActivity(final Activity activity, final ActivityPipedriveApi activityFromApi) {
        activity.setPersonName(activityFromApi.getData().getPersonName());
        activity.getOwner().setName(activityFromApi.getData().getOwnerName());
        activity.setMarkedAsDoneTime(stringToLocalDateTime(activityFromApi.getData().getMarkedAsDoneTime()));
    }

    private LocalDateTime stringToLocalDateTime(final String dateTime) {
        final DateTimeFormatter CUSTOM_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        if (dateTime != null && !dateTime.trim().isEmpty()) {
            return LocalDateTime.parse(dateTime, CUSTOM_DATE_TIME_FORMATTER);
        }
        return null;
    }

    // Helper method to check if activity is marked as done today
    private boolean isMarkedAsDoneToday(final Activity activity, final LocalDate today) {
        return activity.getMarkedAsDoneTime() != null &&
                activity.getMarkedAsDoneTime().toLocalDate().equals(today);
    }

    // Save new activity and publish event
    private Activity saveNewActivity(final Activity activity) {
        final Activity savedActivity = activityRepository.save(activity);
        publishEvent(savedActivity);
        return savedActivity;
    }
}
