package ua.foxminded.application.activity.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.foxminded.domain.activity.model.event.WebhookEvent;
import ua.foxminded.infrastructure.util.JsonParser;

@RestController
@RequestMapping("/test")
public class TestController {

    private final JsonParser jsonParser;

    public TestController (final JsonParser jsonParser) {
        this.jsonParser = jsonParser;
    }

    @PostMapping
    public void test(@RequestBody final String test) {
        final WebhookEvent webhookEvent = jsonParser.parseJson(test, WebhookEvent.class);
        System.out.println(webhookEvent);
    }
}