package ua.foxminded.application.manager.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.foxminded.common.model.dto.OwnerDto;
import ua.foxminded.domain.manager.model.dto.ManagerPointsDto;
import ua.foxminded.domain.manager.service.ManagerPointsFrontendService;
import ua.foxminded.infrastructure.config.ManagerPointsConfig;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping
public class ManagerPointsController {

    private final ManagerPointsFrontendService managerPointsService;
    private final ManagerPointsConfig managerPointsConfig;

    public ManagerPointsController(final ManagerPointsFrontendService managerPointsService,
                                   final ManagerPointsConfig managerPointsConfig) {
        this.managerPointsService = managerPointsService;
        this.managerPointsConfig = managerPointsConfig;
    }

    @GetMapping
    public String displayTodayProgress(final Model model) {
        // Fetch today's manager points
        final List<ManagerPointsDto> todayPoints = managerPointsService.findAllForToday();
        // Fetch normative value
        final int normative = managerPointsConfig.getNorm();

        final List<OwnerDto> managers = managerPointsService.getAllManagers();

        model.addAttribute("managers", managers);
        model.addAttribute("managerPoints", todayPoints);
        model.addAttribute("norm", normative);

        return "manager-progress";
    }

    @GetMapping("/period")
    public String displayProgressByPeriod(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate endDate,
            final Model model) {
        // Fetch manager points for the specified period
        final List<ManagerPointsDto> pointsByPeriod = managerPointsService.getPointsByPeriod(startDate, endDate);
        final int normative = managerPointsConfig.getNorm();
        final List<OwnerDto> managers = managerPointsService.getAllManagers();

        model.addAttribute("managers", managers);
        model.addAttribute("managerPoints", pointsByPeriod);
        model.addAttribute("norm", normative);

        return "manager-progress";
    }

    @GetMapping("/manager-period")
    public String displayProgressByManagerAndPeriod(@RequestParam("managerId") final Long managerId,
                                                    @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate startDate,
                                                    @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate endDate,
                                                    final Model model) {
        // Fetch manager points for the specific manager and period
        final List<ManagerPointsDto> pointsByManagerAndPeriod = managerPointsService.getPointsByManagerAndPeriod(
                managerId, startDate, endDate);
        final int normative = managerPointsConfig.getNorm();

        final List<OwnerDto> managers = managerPointsService.getAllManagers();

        model.addAttribute("managerPoints", pointsByManagerAndPeriod);
        model.addAttribute("norm", normative);
        model.addAttribute("managers", managers);

        return "manager-progress";
    }
}