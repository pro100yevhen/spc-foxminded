package ua.foxminded.application.manager.service;

import org.springframework.stereotype.Service;
import ua.foxminded.application.manager.controller.ManagerPointsRecourse;
import ua.foxminded.common.mapper.TypeMapperFacade;
import ua.foxminded.common.model.dto.OwnerDto;
import ua.foxminded.common.repository.OwnerRepository;
import ua.foxminded.domain.manager.model.dto.ManagerPointsDto;
import ua.foxminded.domain.manager.service.ManagerPointsFrontendService;
import ua.foxminded.infrastructure.config.ManagerPointsConfig;

import java.time.LocalDate;
import java.util.List;

@Service
public class ManagerPointsFrontendServiceImpl implements ManagerPointsFrontendService {

    private final ManagerPointsRecourse recourse;
    private final OwnerRepository ownerRepository;
    private final TypeMapperFacade typeMapperFacade;
    private final int normative;

    public ManagerPointsFrontendServiceImpl(final ManagerPointsRecourse recourse, final OwnerRepository ownerRepository,
                                            final TypeMapperFacade typeMapperFacade,
                                            final ManagerPointsConfig managerPointsConfig) {
        this.recourse = recourse;
        this.ownerRepository = ownerRepository;
        this.typeMapperFacade = typeMapperFacade;
        this.normative = managerPointsConfig.getNorm();
    }

    @Override
    public List<ManagerPointsDto> findAllForToday() {
        final List<ManagerPointsDto> points = recourse.getPointsForToday().getBody();
        return setProgress(points);
    }

    @Override
    public List<ManagerPointsDto> getPointsByPeriod(final LocalDate startDate, final LocalDate endDate) {
        final List<ManagerPointsDto> points = recourse.getAllPointsByPeriod(startDate, endDate).getBody();
        return setProgress(points);
    }

    @Override
    public List<ManagerPointsDto> getPointsByManagerAndPeriod(final Long managerId, final LocalDate startDate,
                                                              final LocalDate endDate) {
        final List<ManagerPointsDto> points = recourse.getPointsByManagerIdAndPeriod(managerId, startDate, endDate).getBody();
        return setProgress(points);
    }

    @Override
    public List<OwnerDto> getAllManagers() {
        return typeMapperFacade.mapList(ownerRepository.findAll(), OwnerDto.class);
    }

    private List<ManagerPointsDto> setProgress(final List<ManagerPointsDto> points) {
        for (final ManagerPointsDto dto : points) {
            final int oneHundredPercent = 100;
            int percentage = (dto.getPoints() * oneHundredPercent) / dto.getNormative();
            if (percentage > oneHundredPercent) {
                percentage = oneHundredPercent;
            }
            dto.setProgress(percentage + "%");
        }
        return points;
    }
}