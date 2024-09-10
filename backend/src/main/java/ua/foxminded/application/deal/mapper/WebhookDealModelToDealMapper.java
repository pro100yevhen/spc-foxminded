package ua.foxminded.application.deal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import ua.foxminded.common.mapper.DataMapper;
import ua.foxminded.domain.deal.model.entity.Deal;
import ua.foxminded.domain.deal.model.webhook.WebhookDealModel;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WebhookDealModelToDealMapper extends DataMapper<WebhookDealModel, Deal> {

    @Override
    default Class<WebhookDealModel> getSourceClass() {
        return WebhookDealModel.class;
    }

    @Override
    default Class<Deal> getTargetClass() {
        return Deal.class;
    }

    @Override
    @Mapping(target = "id", source = "meta.id")
    @Mapping(target = "personName", source = "current.personName")
    @Mapping(target = "stageId", source = "current.stageId")
    @Mapping(target = "owner.id", source = "current.userId")
    @Mapping(target = "owner.name", source = "current.ownerName")
    @Mapping(target = "updatedDealStageDate", source = "meta.timestamp", qualifiedByName = "longToLocalDateTime")
    Deal map(WebhookDealModel target);

    @Named("longToLocalDateTime")
    static LocalDateTime longToLocalDateTime(Long timestamp) {
        return timestamp != null ? LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneOffset.UTC) : null;
    }
}
