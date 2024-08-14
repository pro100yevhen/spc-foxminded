package ua.foxminded.application.activity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.foxminded.common.filter.Filter;
import ua.foxminded.common.mapper.TypeMapperFacade;
import ua.foxminded.domain.activity.model.entity.Activity;
import ua.foxminded.domain.activity.model.webhook.WebhookActivityModel;
import ua.foxminded.domain.activity.service.ActivityService;
import ua.foxminded.infrastructure.util.JsonParser;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    private static final Logger LOG = LoggerFactory.getLogger(ActivityController.class);

    private final JsonParser jsonParser;
    private final Filter activityFilter;
    private final ActivityService activityService;
    private final TypeMapperFacade mapper;

    public ActivityController(final JsonParser jsonParser, final Filter <WebhookActivityModel> activityFilter,
                              final ActivityService activityService, final TypeMapperFacade typeMapperFacade) {
        this.jsonParser = jsonParser;
        this.activityFilter = activityFilter;
        this.activityService = activityService;
        this.mapper = typeMapperFacade;
    }

    @PostMapping
    public void save(@RequestBody final String activity) {
        final WebhookActivityModel webhookEvent = jsonParser.parseJson(activity, WebhookActivityModel.class);
        LOG.info("Parsed WebhookActivityModel: {}", webhookEvent.getEvent());

        if (activityFilter.apply(webhookEvent)) {
            LOG.info("Activity passed the filter criteria");

            final Activity activityEntity = mapper.map(webhookEvent, Activity.class);
            LOG.info("Mapped Activity entity: {}", activityEntity);

            activityService.save(activityEntity);
            LOG.info("Activity saved successfully");
        } else {
            LOG.info("Activity did not pass the filter criteria" + webhookEvent.getMeta());
        }
    }
}