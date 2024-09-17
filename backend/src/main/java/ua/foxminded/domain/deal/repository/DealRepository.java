package ua.foxminded.domain.deal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.foxminded.domain.deal.model.entity.Deal;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DealRepository extends JpaRepository<Deal, Long>{

    Deal save (Deal deal);

    List<Deal> findAllByOwnerIdAndCreatedDateBetween(Long ownerId, LocalDateTime startDay, LocalDateTime endDay);
}
