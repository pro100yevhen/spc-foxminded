package ua.foxminded.application.deal.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.foxminded.domain.deal.model.dto.DealDto;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/manager-deals")
public class DealController {

    private final DealResource dealResource;

    public DealController(final DealResource dealResource) {
        this.dealResource = dealResource;
    }

    @GetMapping
    public String getDealsByOwnerAndDate(@RequestParam final Long ownerId,
                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate date,
                                         final Model model) {
        final List<DealDto> deals = dealResource.findByOwnerAndDate(ownerId, date);
        model.addAttribute("deals", deals);
        return "manager-deals";
    }
}
