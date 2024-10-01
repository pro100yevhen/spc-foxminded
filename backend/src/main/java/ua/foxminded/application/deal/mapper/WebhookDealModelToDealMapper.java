package ua.foxminded.application.deal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ua.foxminded.domain.deal.model.entity.Deal;
import ua.foxminded.domain.deal.model.webhook.WebhookDealModel;
import ua.foxminded.infrastructure.mapper.DataMapper;

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
    @Mapping(target = "id", source = "data.id")
    @Mapping(target = "stageId", source = "data.stageId")
    @Mapping(target = "owner.id", source = "data.ownerId")
    Deal map(WebhookDealModel target);
}
