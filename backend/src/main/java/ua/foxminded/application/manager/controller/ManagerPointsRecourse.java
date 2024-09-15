package ua.foxminded.application.manager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.foxminded.infrastructure.mapper.TypeMapperFacade;
import ua.foxminded.domain.manager.model.dto.ManagerPointsDto;
import ua.foxminded.domain.manager.model.entity.ManagerPoints;
import ua.foxminded.domain.manager.service.ManagerPointsService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/manager-points")
public class ManagerPointsRecourse {

    private final ManagerPointsService managerPointsService;
    private final TypeMapperFacade mapper;
    private final Logger LOG = LoggerFactory.getLogger(ManagerPointsRecourse.class);

    public ManagerPointsRecourse(final ManagerPointsService managerPointsService, final TypeMapperFacade mapper) {
        this.managerPointsService = managerPointsService;
        this.mapper = mapper;
    }

    @GetMapping("/{managerId}")
    public ResponseEntity<List<ManagerPoints>> getPointsByManager(@PathVariable final Long managerId) {
        LOG.info("Fetching points for manager with ID {}", managerId);
        final List<ManagerPoints> points = managerPointsService.findByManagerId(managerId);
        return ResponseEntity.ok(points);
    }

    @GetMapping("/range")
    public ResponseEntity<List<ManagerPointsDto>> getAllPointsByPeriod(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate endDate) {
        LOG.info("Fetching points from {} to {}", startDate, endDate);
        final List<ManagerPoints> points = managerPointsService.findAllByDateBetween(startDate, endDate);
        final List<ManagerPointsDto> pointsDto = mapper.mapList(points, ManagerPointsDto.class);
        return ResponseEntity.ok(pointsDto);
    }

    @GetMapping("/{managerId}/range")
    public ResponseEntity<List<ManagerPointsDto>> getPointsByManagerIdAndPeriod(
            @PathVariable final Long managerId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate endDate) {
        LOG.info("Fetching points for manager with ID {} from {} to {}", managerId, startDate, endDate);
        final List<ManagerPoints> points = managerPointsService.findAllByDateBetweenAndManagerId(startDate, endDate, managerId);
        final List<ManagerPointsDto> pointsDto = mapper.mapList(points, ManagerPointsDto.class);
        return ResponseEntity.ok(pointsDto);
    }

    @GetMapping("/today")
    public ResponseEntity<List<ManagerPointsDto>> getPointsForToday() {
        LOG.info("Fetching points for all managers for today");
        final List<ManagerPoints> pointsToday = managerPointsService.findAllForToday();
        final List<ManagerPointsDto> points = mapper.mapList(pointsToday, ManagerPointsDto.class);

        return ResponseEntity.ok(points);
    }
}