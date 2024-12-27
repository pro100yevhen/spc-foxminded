package ua.foxminded.application.deal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import ua.foxminded.domain.deal.model.entity.Deal;
import ua.foxminded.domain.deal.model.webhook.WebhookDealModel;
import ua.foxminded.infrastructure.config.TimezoneProvider;
import ua.foxminded.infrastructure.mapper.DataMapper;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class WebhookDealModelToDealMapper implements DataMapper<WebhookDealModel, Deal> {

    @Autowired
    private TimezoneProvider timezoneProvider;

    @Override
    public Class<WebhookDealModel> getSourceClass() {
        return WebhookDealModel.class;
    }

    @Override
    public Class<Deal> getTargetClass() {
        return Deal.class;
    }

    @Override
    @Mapping(target = "id", source = "data.id")
    @Mapping(target = "stageId", source = "data.stageId")
    @Mapping(target = "owner.id", source = "data.ownerId")
    @Mapping(target = "updatedDealStageDate", source = "meta.timestamp", qualifiedByName = "stringToLocalDateTime")
    public abstract Deal map(WebhookDealModel target);

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
