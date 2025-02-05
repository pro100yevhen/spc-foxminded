package ua.foxminded.application.pointsconfiguration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.foxminded.domain.pointsconfiguration.model.entity.GlobalConfiguration;
import ua.foxminded.domain.pointsconfiguration.service.GlobalConfigurationService;

@Controller
public class GlobalConfigurationController {

    private final GlobalConfigurationService service;

    public GlobalConfigurationController(final GlobalConfigurationService service) {
        this.service = service;
    }

    @GetMapping("/config")
    public String getConfigPage(final Model model) {

        model.addAttribute("config", service.getConfiguration());
        return "config";
    }

    @PostMapping("/config")
    public String updateConfig(final GlobalConfiguration config) {
        service.save(config);
        return "redirect:/config";
    }
}
