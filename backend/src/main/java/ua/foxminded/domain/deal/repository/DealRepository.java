package ua.foxminded.domain.deal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.foxminded.domain.deal.model.entity.Deal;

@Repository
public interface DealRepository extends JpaRepository<Deal, Long>{

    Deal save (Deal deal);
}
