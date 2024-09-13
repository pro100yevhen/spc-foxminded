package ua.foxminded.application.deal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import ua.foxminded.common.mapper.DataMapper;
import ua.foxminded.domain.deal.model.entity.Deal;
import ua.foxminded.domain.deal.model.webhook.WebhookDealModel;
import ua.foxminded.infrastructure.config.TimezoneProvider;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

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
    @Mapping(target = "id", source = "meta.id")
    @Mapping(target = "personName", source = "current.personName")
    @Mapping(target = "stageId", source = "current.stageId")
    @Mapping(target = "owner.id", source = "current.userId")
    @Mapping(target = "owner.name", source = "current.ownerName")
    @Mapping(target = "updatedDealStageDate", source = "meta.timestamp", qualifiedByName = "longToLocalDateTime")
    public abstract Deal map(WebhookDealModel target);

    @Named("longToLocalDateTime")
    LocalDateTime longToLocalDateTime(final Long timestamp) {
        return timestamp != null ? LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), timezoneProvider.getZoneId()) : null;
    }
}
