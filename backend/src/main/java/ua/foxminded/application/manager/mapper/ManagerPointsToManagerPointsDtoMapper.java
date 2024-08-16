package ua.foxminded.application.manager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import ua.foxminded.common.mapper.DataMapper;
import ua.foxminded.common.repository.OwnerRepository;
import ua.foxminded.domain.manager.model.dto.ManagerPointsDto;
import ua.foxminded.domain.manager.model.entity.ManagerPoints;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ManagerPointsToManagerPointsDtoMapper implements DataMapper<ManagerPoints, ManagerPointsDto> {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public Class<ManagerPoints> getSourceClass() {
        return ManagerPoints.class;
    }

    @Override
    public Class<ManagerPointsDto> getTargetClass() {
        return ManagerPointsDto.class;
    }

    @Override
    @Mapping(target = "managerName", source = "managerId", qualifiedByName = "getManagerName")
    public abstract ManagerPointsDto map(ManagerPoints source);

    @Named("getManagerName")
    String getManagerName(final Long managerId) {
        return ownerRepository.findById(managerId)
                .map(owner -> owner.getName())
                .orElse(null);
    }
}
