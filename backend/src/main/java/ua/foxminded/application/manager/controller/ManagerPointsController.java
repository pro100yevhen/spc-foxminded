package ua.foxminded.application.manager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.foxminded.domain.manager.model.ManagerPoints;
import ua.foxminded.domain.manager.service.ManagerPointsService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/manager/points")
public class ManagerPointsController {

    private final ManagerPointsService managerPointsService;
    private final Logger LOG = LoggerFactory.getLogger(ManagerPointsController.class);

    public ManagerPointsController(final ManagerPointsService managerPointsService) {
        this.managerPointsService = managerPointsService;
    }

    @GetMapping("/{managerId}")
    public List<ManagerPoints> getPointsByManagerIdAndDate(
            @PathVariable final Long managerId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate date) {
        LOG.info("Fetching points for manager with ID {} on date {}", managerId, date);
        return managerPointsService.findByManagerIdAndDate(managerId, date);
    }

    @GetMapping("/range")
    public List<ManagerPoints> getAllPointsByPeriod(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate endDate) {
        LOG.info("Fetching points from {} to {}", startDate, endDate);
        return managerPointsService.findAllByPeriod(startDate, endDate);
    }

    @GetMapping("/{managerId}/range")
    public List<ManagerPoints> getPointsByManagerIdAndPeriod(
            @PathVariable final Long managerId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate endDate) {
        LOG.info("Fetching points for manager with ID {} from {} to {}", managerId, startDate, endDate);
        return managerPointsService.findAllByPeriodAndManagerId(startDate, endDate, managerId);
    }
}