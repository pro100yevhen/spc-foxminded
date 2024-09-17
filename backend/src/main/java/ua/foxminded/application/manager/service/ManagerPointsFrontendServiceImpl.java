package ua.foxminded.application.manager.service;

import org.springframework.stereotype.Service;
import ua.foxminded.application.manager.controller.ManagerPointsRecourse;
import ua.foxminded.infrastructure.mapper.TypeMapperFacade;
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
        final List<ManagerPointsDto> pointsWithProgress = fetchAndSetProgress(startDate, endDate);

        final Map<Long, List<ManagerPointsDto>> pointsByManager = groupPointsByManager(pointsWithProgress);

        return calculateAverageProgress(pointsByManager);
    }

    private List<ManagerPointsDto> fetchAndSetProgress(final LocalDate startDate, final LocalDate endDate) {
        final List<ManagerPointsDto> points = recourse.getAllPointsByPeriod(startDate, endDate).getBody();
        return setProgress(points);
    }

    private Map<Long, List<ManagerPointsDto>> groupPointsByManager(final List<ManagerPointsDto> pointsWithProgress) {
        final int minimumPointsToCount = 15;
        return pointsWithProgress.stream()
                .filter(dto -> dto.getPoints() >= minimumPointsToCount)
                .collect(Collectors.groupingBy(ManagerPointsDto::getManagerId));
    }

    private List<ManagerPointsDto> calculateAverageProgress(final Map<Long, List<ManagerPointsDto>> pointsByManager) {
        final List<ManagerPointsDto> averageProgressPerMonth = new ArrayList<>();

        for (final Map.Entry<Long, List<ManagerPointsDto>> entry : pointsByManager.entrySet()) {
            final Long managerId = entry.getKey();
            final List<ManagerPointsDto> managerPoints = entry.getValue();

            final Double avgProgress = calculateAverageProgressForManager(managerPoints);
            final int activeDays = managerPoints.size();

            final ManagerPointsDto avgDto = createAverageDto(managerId, managerPoints, avgProgress, activeDays);
            averageProgressPerMonth.add(avgDto);
        }

        return averageProgressPerMonth;
    }

    private Double calculateAverageProgressForManager(final List<ManagerPointsDto> managerPoints) {
        final Double totalProgress = managerPoints.stream()
                .mapToDouble(ManagerPointsDto::getProgress)
                .sum();
        return totalProgress / managerPoints.size();
    }

    private ManagerPointsDto createAverageDto(final Long managerId, final List<ManagerPointsDto> managerPoints,
                                              final Double avgProgress, final int activeDays) {
        final ManagerPointsDto avgDto = new ManagerPointsDto();
        avgDto.setManagerId(managerId);
        avgDto.setManagerName(managerPoints.get(0).getManagerName());
        avgDto.setProgress(avgProgress);
        avgDto.setNormative(managerPoints.get(0).getNormative());
        avgDto.setActiveDays(activeDays);
        return avgDto;
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