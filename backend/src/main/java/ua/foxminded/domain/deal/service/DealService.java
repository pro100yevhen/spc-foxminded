package ua.foxminded.domain.deal.service;

import ua.foxminded.domain.deal.model.entity.Deal;

import java.time.LocalDate;
import java.util.List;

public interface DealService {

    Deal save(Deal deal);

    List<Deal> findByOwnerAndDate(Long ownerId, LocalDate date);

    void delete(Long id);
}
