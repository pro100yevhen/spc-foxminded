package ua.foxminded.domain.manager.service;

import ua.foxminded.common.model.dto.OwnerDto;

public interface ManagerService {

    OwnerDto getById(Long id);

    OwnerDto update(OwnerDto ownerDto);
}
