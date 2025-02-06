package ua.foxminded.application.activity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import ua.foxminded.domain.activity.model.entity.Activity;
import ua.foxminded.domain.activity.model.webhook.WebhookActivityModel;
import ua.foxminded.infrastructure.config.TimezoneProvider;
import ua.foxminded.infrastructure.mapper.DataMapper;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class WebhookActivityModelToActivityMapper implements DataMapper<WebhookActivityModel, Activity> {

    @Autowired
    private TimezoneProvider timezoneProvider;

    @Override
    public Class<WebhookActivityModel> getSourceClass() {
        return WebhookActivityModel.class;
    }

    @Override
    public Class<Activity> getTargetClass() {
        return Activity.class;
    }

    @Override
    @Mapping(target = "id", source = "data.id")
    @Mapping(target = "dealId", source = "data.dealId")
    @Mapping(target = "busyFlag", source = "data.busyFlag")
    @Mapping(target = "typeName", source = "data.type")
    @Mapping(target = "owner.id", source = "data.ownerId")
    @Mapping(target = "personId", source = "data.personId")
    @Mapping(target = "updatedActivityDate", source = "meta.timestamp", qualifiedByName = "stringToLocalDateTime")
    public abstract Activity map(WebhookActivityModel target);

    @Named("stringToLocalDateTime")
    LocalDateTime stringToLocalDateTime(final String dateTime) {
        if (dateTime != null && !dateTime.trim().isEmpty()) {
            // Parse the string to ZonedDateTime first
            final ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateTime, DateTimeFormatter.ISO_DATE_TIME);
            // Convert it to LocalDateTime in the desired timezone
            return zonedDateTime.withZoneSameInstant(timezoneProvider.getZoneId()).toLocalDateTime();
        }
        return null;
    }
}