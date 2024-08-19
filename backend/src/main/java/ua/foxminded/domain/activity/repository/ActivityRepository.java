package ua.foxminded.domain.activity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.foxminded.domain.activity.model.entity.Activity;

import java.time.LocalDateTime;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long>{

    Activity save(Activity activity);

    Activity findByPersonIdAndCreatedDateBetween(Long personId, LocalDateTime startDate, LocalDateTime endDate);

}
