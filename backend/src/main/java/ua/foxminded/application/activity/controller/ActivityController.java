package ua.foxminded.application.activity.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.foxminded.common.filter.Filter;
import ua.foxminded.common.mapper.TypeMapperFacade;
import ua.foxminded.domain.activity.model.entity.Activity;
import ua.foxminded.domain.activity.model.event.WebhookActivityEventModel;
import ua.foxminded.domain.activity.service.ActivityService;
import ua.foxminded.infrastructure.util.JsonParser;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    private final JsonParser jsonParser;
    private final Filter activityFilter;
    private final ActivityService activityService;
    private final TypeMapperFacade mapper;

    public ActivityController(final JsonParser jsonParser, final Filter activityFilter,
                              final ActivityService activityService, final TypeMapperFacade typeMapperFacade) {
        this.jsonParser = jsonParser;
        this.activityFilter = activityFilter;
        this.activityService = activityService;
        this.mapper = typeMapperFacade;
    }

    @PostMapping
    public void test(@RequestBody final String activity) {
        final WebhookActivityEventModel webhookEvent = jsonParser.parseJson(activity, WebhookActivityEventModel.class);
        if (activityFilter.apply(webhookEvent)) {
            final Activity  activityEntity = mapper.map(webhookEvent, Activity.class);
            activityService.save(activityEntity);
        }
    }
}
