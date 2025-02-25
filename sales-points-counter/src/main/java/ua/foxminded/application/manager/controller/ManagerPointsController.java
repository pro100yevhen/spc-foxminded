package ua.foxminded.application.manager.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.foxminded.common.model.dto.OwnerDto;
import ua.foxminded.domain.pointsconfiguration.model.entity.GlobalConfiguration;
import ua.foxminded.domain.pointsconfiguration.service.GlobalConfigurationService;
import ua.foxminded.domain.manager.model.dto.ManagerPointsDto;
import ua.foxminded.domain.manager.service.ManagerPointsFrontendService;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping
public class ManagerPointsController {

    private final ManagerPointsFrontendService managerPointsService;
    private final GlobalConfigurationService configurationService;

    public ManagerPointsController(final ManagerPointsFrontendService managerPointsService,
                                   final GlobalConfigurationService configurationService) {
        this.managerPointsService = managerPointsService;
        this.configurationService = configurationService;
    }

    @GetMapping
    public String displayTodayProgress(final Model model) {
        final GlobalConfiguration config = configurationService.getConfiguration();
        final List<ManagerPointsDto> todayPoints = new ArrayList<>(managerPointsService.findAllForToday());
        final int normative = config.getPointsNormativeChallenge();

        final List<OwnerDto> managers = managerPointsService.getAllManagers();

        todayPoints.sort(Comparator
                .comparing(ManagerPointsDto::getDate)
                .thenComparing(manager -> manager.getManagerName(), Comparator.nullsLast(Comparator.naturalOrder())));

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
        final GlobalConfiguration config = configurationService.getConfiguration();
        final List<ManagerPointsDto> pointsByPeriod = new ArrayList<>(
                managerPointsService.getPointsByPeriod(startDate, endDate));
        final int normative = config.getPointsNormativeChallenge();
        final List<OwnerDto> managers = managerPointsService.getAllManagers();

        pointsByPeriod.sort(Comparator
                .comparing(ManagerPointsDto::getDate)
                .thenComparing(manager -> manager.getManagerName(), Comparator.nullsLast(Comparator.naturalOrder())));

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
        final GlobalConfiguration config = configurationService.getConfiguration();
        final List<ManagerPointsDto> pointsByManagerAndPeriod = new ArrayList<>(
                managerPointsService.getPointsByManagerAndPeriod(
                        managerId, startDate, endDate));
        final int normative = config.getPointsNormativeChallenge();

        pointsByManagerAndPeriod.sort(Comparator
                .comparing(ManagerPointsDto::getDate)
                .thenComparing(manager -> manager.getManagerName(), Comparator.nullsLast(Comparator.naturalOrder())));

        final List<OwnerDto> managers = managerPointsService.getAllManagers();

        model.addAttribute("managerPoints", pointsByManagerAndPeriod);
        model.addAttribute("norm", normative);
        model.addAttribute("managers", managers);

        return "manager-progress";
    }

    @GetMapping("/average-progress")
    public String displayAverageProgress(
            @RequestParam("month") @DateTimeFormat(pattern = "yyyy-MM") final YearMonth month,
            final Model model) {
        final LocalDate startDate = month.atDay(1);
        final LocalDate endDate = month.atEndOfMonth();

        final List<ManagerPointsDto> averageProgress = managerPointsService.getAverageProgressPerMonth(startDate,
                endDate);

        final List<OwnerDto> managers = managerPointsService.getAllManagers()
                .stream()
                .filter(manager -> averageProgress.stream()
                        .anyMatch(progress -> progress.getManagerId().equals(manager.getId())))
                .toList();

        model.addAttribute("averageProgress", averageProgress);
        model.addAttribute("managers", managers);
        model.addAttribute("month", month);

        return "average-progress";
    }
}