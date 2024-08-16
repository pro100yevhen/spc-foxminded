package ua.foxminded.application.manager.service;

import org.springframework.stereotype.Service;
import ua.foxminded.application.manager.controller.ManagerPointsRecourse;
import ua.foxminded.common.mapper.TypeMapperFacade;
import ua.foxminded.common.model.dto.OwnerDto;
import ua.foxminded.common.repository.OwnerRepository;
import ua.foxminded.domain.manager.model.dto.ManagerPointsDto;
import ua.foxminded.domain.manager.service.ManagerPointsFrontendService;

import java.time.LocalDate;
import java.util.List;

@Service
public class ManagerPointsFrontendServiceImpl implements ManagerPointsFrontendService {

    private final ManagerPointsRecourse recourse;
    private final OwnerRepository ownerRepository;
    private final TypeMapperFacade typeMapperFacade;

    public ManagerPointsFrontendServiceImpl(final ManagerPointsRecourse recourse, final OwnerRepository ownerRepository,
                                            final TypeMapperFacade typeMapperFacade) {
        this.recourse = recourse;
        this.ownerRepository = ownerRepository;
        this.typeMapperFacade = typeMapperFacade;
    }

    @Override
    public List<ManagerPointsDto> findAllForToday() {
        return recourse.getPointsForToday().getBody();
    }

    @Override
    public List<ManagerPointsDto> getPointsByPeriod(final LocalDate startDate, final LocalDate endDate) {
        return recourse.getAllPointsByPeriod(startDate, endDate).getBody();
    }

    @Override
    public List<ManagerPointsDto> getPointsByManagerAndPeriod(final Long managerId, final LocalDate startDate,
                                                              final LocalDate endDate) {
        return recourse.getPointsByManagerIdAndPeriod(managerId, startDate, endDate).getBody();
    }

    @Override
    public List<OwnerDto> getAllManagers() {
        return typeMapperFacade.mapList(ownerRepository.findAll(), OwnerDto.class);
    }
}