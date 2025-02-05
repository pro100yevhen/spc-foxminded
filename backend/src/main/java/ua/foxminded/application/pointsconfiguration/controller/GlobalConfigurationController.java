package ua.foxminded.application.pointsconfiguration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.foxminded.common.model.dto.OwnerDto;
import ua.foxminded.domain.manager.service.ManagerPointsFrontendService;
import ua.foxminded.domain.pointsconfiguration.model.dto.GlobalConfigurationDto;
import ua.foxminded.domain.pointsconfiguration.model.entity.GlobalConfiguration;
import ua.foxminded.domain.pointsconfiguration.service.GlobalConfigurationService;
import ua.foxminded.infrastructure.mapper.TypeMapperFacade;

import java.util.List;

@Controller
public class GlobalConfigurationController {

    private final GlobalConfigurationService service;
    private final ManagerPointsFrontendService managerService;
    private final TypeMapperFacade mapper;

    public GlobalConfigurationController(final GlobalConfigurationService service, final TypeMapperFacade mapper,
                                         final ManagerPointsFrontendService managerService) {
        this.service = service;
        this.mapper = mapper;
        this.managerService = managerService;
    }

    @GetMapping("/config")
    public String getConfigPage(final Model model) {
        final GlobalConfigurationDto configDto = mapper.map(service.getConfiguration(), GlobalConfigurationDto.class);
        final List<OwnerDto> managers = managerService.getAllManagers();

        model.addAttribute("config", configDto);
        model.addAttribute("managers", managers);

        return "config";
    }

    @PostMapping("/config")
    public String updateConfig(final GlobalConfigurationDto config, final RedirectAttributes redirectAttributes) {
        service.save(mapper.map(config, GlobalConfiguration.class));
        redirectAttributes.addFlashAttribute("successMessage", "Configuration updated successfully!");
        return "redirect:/config";
    }
}
