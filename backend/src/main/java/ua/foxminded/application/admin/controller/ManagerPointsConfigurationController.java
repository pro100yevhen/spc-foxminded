package ua.foxminded.application.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.foxminded.domain.admin.model.ManagerPointsConfiguration;
import ua.foxminded.domain.admin.service.ManagerPointsConfigurationService;

@Controller
public class ManagerPointsConfigurationController {

    private final ManagerPointsConfigurationService managerPointsConfigurationService;

    public ManagerPointsConfigurationController(final ManagerPointsConfigurationService managerPointsConfigurationService) {
        this.managerPointsConfigurationService = managerPointsConfigurationService;
    }

    @GetMapping("/config")
    public String getConfigPage(final Model model) {
        model.addAttribute("config", managerPointsConfigurationService.getConfiguration());
        return "config";
    }

    @PostMapping("/config")
    public String updateConfig(final ManagerPointsConfiguration config) {
        managerPointsConfigurationService.save(config);
        return "redirect:/config";
    }
}
