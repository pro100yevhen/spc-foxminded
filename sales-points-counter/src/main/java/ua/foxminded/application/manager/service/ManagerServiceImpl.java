package ua.foxminded.application.manager.service;

import org.springframework.stereotype.Service;
import ua.foxminded.common.model.dto.OwnerDto;
import ua.foxminded.common.model.entity.Owner;
import ua.foxminded.common.repository.OwnerRepository;
import ua.foxminded.domain.manager.service.ManagerService;
import ua.foxminded.infrastructure.mapper.TypeMapperFacade;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final OwnerRepository ownerRepository;
    private final TypeMapperFacade typeMapperFacade;

    public ManagerServiceImpl(final OwnerRepository ownerRepository, final TypeMapperFacade typeMapperFacade) {
        this.ownerRepository = ownerRepository;
        this.typeMapperFacade = typeMapperFacade;
    }

    @Override
    public OwnerDto getById(final Long id) {
        return ownerRepository.findById(id)
                .map(owner -> typeMapperFacade.map(owner, OwnerDto.class))
                .orElseThrow(() -> new IllegalArgumentException("Manager not found"));
    }

    @Override
    public OwnerDto update(final OwnerDto ownerDto) {
        Owner owner = typeMapperFacade.map(ownerDto, Owner.class);
        owner = ownerRepository.save(owner);
        return typeMapperFacade.map(owner, OwnerDto.class);
    }
}