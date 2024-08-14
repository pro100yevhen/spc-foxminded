package ua.foxminded.application.deal.service;

import org.springframework.stereotype.Service;
import ua.foxminded.common.model.entity.Owner;
import ua.foxminded.common.repository.OwnerRepository;
import ua.foxminded.domain.deal.model.entity.Deal;
import ua.foxminded.domain.deal.repository.DealRepository;
import ua.foxminded.domain.deal.service.DealService;

@Service
public class DealServiceImpl implements DealService {

    private final DealRepository dealRepository;
    private final OwnerRepository ownerRepository;

    public DealServiceImpl(final DealRepository dealRepository, final OwnerRepository ownerRepository) {
        this.dealRepository = dealRepository;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Deal save(final Deal deal) {
        // Check if the owner exists
        final Owner owner = deal.getOwner();
        if (owner != null && owner.getId() != null) {
            final Owner existingOwner = ownerRepository.findById(owner.getId()).orElse(null);
            if (existingOwner != null) {
                // Use the existing owner
                deal.setOwner(existingOwner);
            } else {
                // Save new owner
                ownerRepository.save(owner);
            }
        }
        return dealRepository.save(deal);
    }
}
