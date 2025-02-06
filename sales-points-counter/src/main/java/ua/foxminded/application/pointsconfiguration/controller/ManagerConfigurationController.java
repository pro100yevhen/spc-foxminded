package ua.foxminded.application.pointsconfiguration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.foxminded.domain.pointsconfiguration.model.dto.ManagerPointsConfigurationDto;
import ua.foxminded.domain.pointsconfiguration.model.entity.ManagerPointsConfiguration;
import ua.foxminded.domain.pointsconfiguration.service.ManagerPointsConfigurationService;
import ua.foxminded.infrastructure.mapper.TypeMapperFacade;

@Controller
public class ManagerConfigurationController {

    private final ManagerPointsConfigurationService configService;
    private final TypeMapperFacade mapper;

    public ManagerConfigurationController(
            final ManagerPointsConfigurationService configService,
            final TypeMapperFacade mapper
    ) {
        this.configService = configService;
        this.mapper = mapper;
    }

    @GetMapping("/managers/{ownerId}/config")
    public String getManagerConfigPage(
            @PathVariable final Long ownerId,
            final Model model
    ) {
        final ManagerPointsConfiguration config = configService.getConfiguration(ownerId);
        final ManagerPointsConfigurationDto configDto = mapper.map(config, ManagerPointsConfigurationDto.class);
        model.addAttribute("config", configDto);
        model.addAttribute("ownerId", ownerId);
        return "manager-config";
    }

    @PostMapping("/managers/{ownerId}/config")
    public String updateManagerConfig(
            @PathVariable final Long ownerId,
            final ManagerPointsConfigurationDto configDto,
            final RedirectAttributes redirectAttributes
    ) {
        final ManagerPointsConfiguration config = mapper.map(configDto, ManagerPointsConfiguration.class);
        config.setOwnerId(ownerId);
        configService.save(config);
        redirectAttributes.addFlashAttribute("successMessage", "Manager configuration updated successfully!");
        return "redirect:/managers/" + ownerId + "/config";
    }
}