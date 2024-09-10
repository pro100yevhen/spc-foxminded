package ua.foxminded.application.manager.service;

import org.springframework.stereotype.Service;
import ua.foxminded.application.manager.controller.ManagerPointsRecourse;
import ua.foxminded.common.mapper.TypeMapperFacade;
import ua.foxminded.common.model.dto.OwnerDto;
import ua.foxminded.common.repository.OwnerRepository;
import ua.foxminded.domain.manager.model.dto.ManagerPointsDto;
import ua.foxminded.domain.manager.service.ManagerPointsFrontendService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Override
    public List<ManagerPointsDto> getAverageProgressPerMonth(final LocalDate startDate, final LocalDate endDate) {
        // Fetch points and set progress for each manager
        final List<ManagerPointsDto> points = recourse.getAllPointsByPeriod(startDate, endDate).getBody();
        final List<ManagerPointsDto> pointsWithProgress = setProgress(points); // Set progress before proceeding

        // Group points by manager
        final Map<Long, List<ManagerPointsDto>> pointsByManager = pointsWithProgress.stream()
                .filter(dto -> dto.getPoints() >= 15)
                .collect(Collectors.groupingBy(ManagerPointsDto::getManagerId));

        final List<ManagerPointsDto> averageProgressPerMonth = new ArrayList<>();

        // Calculate average progress for each manager
        for (final Map.Entry<Long, List<ManagerPointsDto>> entry : pointsByManager.entrySet()) {
            final Long managerId = entry.getKey();
            final List<ManagerPointsDto> managerPoints = entry.getValue();

            final Double totalProgress = managerPoints.stream().mapToDouble(ManagerPointsDto::getProgress).sum();
            final int activeDays = managerPoints.size();

            // Calculate the average progress
            final Double avgProgress = totalProgress / activeDays;

            // Create a new DTO for the manager's average progress
            final ManagerPointsDto avgDto = new ManagerPointsDto();
            avgDto.setManagerId(managerId);
            avgDto.setManagerName(managerPoints.get(0).getManagerName());
            avgDto.setProgress(avgProgress);
            avgDto.setNormative(managerPoints.get(0).getNormative());
            avgDto.setActiveDays(activeDays);

            // Add the DTO to the result list
            averageProgressPerMonth.add(avgDto);
        }

        return averageProgressPerMonth;
    }

    private List<ManagerPointsDto> setProgress(final List<ManagerPointsDto> points) {
        for (final ManagerPointsDto dto : points) {
            final Double oneHundredPercent = 100d;
            Double percentage = (dto.getPoints() * oneHundredPercent) / dto.getNormative();
            if (percentage > oneHundredPercent) {
                percentage = oneHundredPercent;
            }
            dto.setProgress(percentage);
        }
        return points;
    }
}