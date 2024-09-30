package ua.foxminded.application.activity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.foxminded.common.filter.Filter;
import ua.foxminded.infrastructure.mapper.TypeMapperFacade;
import ua.foxminded.domain.activity.model.dto.ActivityDto;
import ua.foxminded.domain.activity.model.entity.Activity;
import ua.foxminded.domain.activity.model.webhook.WebhookActivityModel;
import ua.foxminded.domain.activity.service.ActivityService;
import ua.foxminded.infrastructure.util.JsonParser;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityResource {

    private static final Logger LOG = LoggerFactory.getLogger(ActivityResource.class);

    private final JsonParser jsonParser;
    private final Filter activityFilter;
    private final ActivityService activityService;
    private final TypeMapperFacade mapper;

    public ActivityResource(final JsonParser jsonParser, final Filter<WebhookActivityModel> activityFilter,
                            final ActivityService activityService, final TypeMapperFacade typeMapperFacade) {
        this.jsonParser = jsonParser;
        this.activityFilter = activityFilter;
        this.activityService = activityService;
        this.mapper = typeMapperFacade;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody final String activity) {
        final WebhookActivityModel webhookEvent = jsonParser.parseJson(activity, WebhookActivityModel.class);
        LOG.info("Parsed WebhookActivityModel: {}", webhookEvent.getData());

//        if (activityFilter.apply(webhookEvent)) {
            LOG.info("Activity passed the filter criteria");

            final Activity activityEntity = mapper.map(webhookEvent, Activity.class);
                LOG.info("Mapped Activity entity: {}", activityEntity);

            activityService.save(activityEntity);
            LOG.info("Activity saved successfully");
//        } else {
            LOG.info("Activity did not pass the filter criteria: PersonName={}, Done={}, UserId={}, BusyFlag={}",
                    webhookEvent.getData().getPersonId(),
                    webhookEvent.getData().isDone(),
                    webhookEvent.getData().getOwnerId(),
                    webhookEvent.getData().isBusyFlag());
//        }

        // Return 200 OK regardless of whether the activity was saved or not
        return ResponseEntity.ok("Processed successfully");
    }

    @GetMapping
    public List<ActivityDto> findByOwnerAndDate(@RequestParam final Long ownerId, @RequestParam final LocalDate date) {
        return activityService.findByOwnerAndDate(ownerId, date).stream()
                .map(activity -> mapper.map(activity, ActivityDto.class))
                .toList();
    }

    @DeleteMapping
    public void delete(@RequestParam final Long id) {
        activityService.delete(id);
    }
}