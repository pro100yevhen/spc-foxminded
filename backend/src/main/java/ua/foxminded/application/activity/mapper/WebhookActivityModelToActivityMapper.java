package ua.foxminded.application.activity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import ua.foxminded.common.mapper.DataMapper;
import ua.foxminded.domain.activity.model.entity.Activity;
import ua.foxminded.domain.activity.model.webhook.WebhookActivityModel;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WebhookActivityModelToActivityMapper extends DataMapper<WebhookActivityModel, Activity> {

    @Override
    default Class<WebhookActivityModel> getSourceClass() {
        return WebhookActivityModel.class;
    }

    @Override
    default Class<Activity> getTargetClass() {
        return Activity.class;
    }

    @Override
    @Mapping(target = "id", source = "meta.id")
    @Mapping(target = "dealId", source = "current.dealId")
    @Mapping(target = "personName", source = "current.personName")
    @Mapping(target = "busyFlag", source = "current.busyFlag")
    @Mapping(target = "typeName", source = "current.typeName")
    @Mapping(target = "owner.id", source = "current.userId")
    @Mapping(target = "personId", source = "current.personId")
    @Mapping(target = "owner.name", source = "current.ownerName")
    @Mapping(target = "updatedActivityDate", source = "meta.timestamp", qualifiedByName = "longToLocalDateTime")
    @Mapping(target = "markedAsDoneTime", source = "current.markedAsDoneTime", qualifiedByName = "stringToLocalDateTime")
    Activity map(WebhookActivityModel target);

    @Named("longToLocalDateTime")
    static LocalDateTime longToLocalDateTime(Long timestamp) {
        return timestamp != null ? LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneOffset.UTC) : null;
    }

    @Named("stringToLocalDateTime")
    static LocalDateTime stringToLocalDateTime(String dateTime) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        if (dateTime == null || dateTime.trim().isEmpty()) {
            return null;
        } else {
            return LocalDateTime.parse(dateTime, formatter);
        }
    }
}
