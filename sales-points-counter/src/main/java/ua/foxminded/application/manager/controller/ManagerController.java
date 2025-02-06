package ua.foxminded.application.manager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.foxminded.common.model.dto.OwnerDto;
import ua.foxminded.domain.manager.service.ManagerService;

@Controller
@RequestMapping("/managers")
public class ManagerController {

    private final ManagerService managerService;
    private final Logger LOG = LoggerFactory.getLogger(ManagerController.class);

    public ManagerController(final ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/{id}/update")
    public String updateManagerPage(@PathVariable final Long id, final Model model) {
        LOG.info("Received request to load update page for manager with id: {}", id);
        final OwnerDto manager = managerService.getById(id);
        model.addAttribute("manager", manager);
        return "manager/update";
    }

    @PostMapping("/{id}/update")
    public String updateManager(@PathVariable final Long id, @ModelAttribute final OwnerDto managerDto) {
        LOG.info("Received request to update manager with id: {}", id);
        managerService.update(managerDto);
        return "redirect:/";
    }
}