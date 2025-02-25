package ua.foxminded.application.deal.service;

import org.springframework.stereotype.Service;
import ua.foxminded.application.pipedriveapi.service.PipedriveApiClient;
import ua.foxminded.common.event.EventPublisher;
import ua.foxminded.common.model.entity.Owner;
import ua.foxminded.common.repository.OwnerRepository;
import ua.foxminded.domain.deal.model.entity.Deal;
import ua.foxminded.domain.deal.model.event.DealDeletedEvent;
import ua.foxminded.domain.deal.model.event.DealSavedEvent;
import ua.foxminded.domain.deal.repository.DealRepository;
import ua.foxminded.domain.deal.service.DealService;
import ua.foxminded.domain.pipedriveapi.model.deal.DealPipedriveApi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class DealServiceImpl implements DealService {

    private final DealRepository dealRepository;
    private final OwnerRepository ownerRepository;
    private final EventPublisher eventPublisher;
    private final PipedriveApiClient apiClient;

    public DealServiceImpl(final DealRepository dealRepository, final OwnerRepository ownerRepository,
                           final EventPublisher eventPublisher, final PipedriveApiClient apiClient) {
        this.dealRepository = dealRepository;
        this.ownerRepository = ownerRepository;
        this.eventPublisher = eventPublisher;
        this.apiClient = apiClient;
    }

    @Override
    public Deal save(final Deal deal) {
        final DealPipedriveApi dealApi = apiClient.getDealById(deal.getId()).block();
        addDataToDeal(deal, dealApi);
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

        // Check if the deal with the same ID already exists
        if (deal.getId() != null) {
            final Optional<Deal> existingDeal = dealRepository.findById(deal.getId());
            if (existingDeal.isPresent()) {
                // If deal exists, return the existing deal
                return existingDeal.get();
            }
        }

        // Save the new deal and publish an event
        final Deal savedDeal = dealRepository.save(deal);
        eventPublisher.publishEvent(new DealSavedEvent(savedDeal.getOwner().getId()));
        return savedDeal;
    }

    @Override
    public List<Deal> findByOwnerAndDate(final Long ownerId, final LocalDate date) {
        final LocalDateTime startDateTime = date.atStartOfDay();
        final LocalDateTime endDateTime = date.atTime(LocalTime.MAX);
        return dealRepository.findAllByOwnerIdAndCreatedDateBetween(ownerId, startDateTime, endDateTime);
    }

    @Override
    public void delete(final Long id) {
        final Deal deal = dealRepository.findById(id).get();
        dealRepository.deleteById(id);
        eventPublisher.publishEvent(new DealDeletedEvent(deal.getOwner().getId(), deal.getCreatedDate()));
    }

    private void addDataToDeal(final Deal deal, final DealPipedriveApi dealApi) {
        deal.setPersonName(dealApi.getData().getPerson().getName());
        deal.getOwner().setName(dealApi.getData().getUser().getName());

    }
}