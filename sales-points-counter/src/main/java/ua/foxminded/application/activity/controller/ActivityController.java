package ua.foxminded.application.activity.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.foxminded.domain.activity.model.dto.ActivityDto;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/manager-activities")
public class ActivityController {

    private final ActivityResource activityResource;

    public ActivityController(final ActivityResource activityResource) {
        this.activityResource = activityResource;
    }

    @GetMapping
    public String getActivitiesByOwnerAndDate(@RequestParam final Long ownerId,
                                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate date,
                                               final Model model) {

        final List<ActivityDto> activities = activityResource.findByOwnerAndDate(ownerId, date);
        model.addAttribute("activities", activities);
        return "manager-activities";
    }
}
