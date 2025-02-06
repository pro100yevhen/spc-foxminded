package ua.foxminded.domain.activity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.foxminded.domain.activity.model.entity.Activity;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long>{

    Activity save(Activity activity);

    Activity findByPersonIdAndCreatedDateBetween(Long personId, LocalDateTime startDate, LocalDateTime endDate);

    List<Activity> findAllByOwnerIdAndMarkedAsDoneTimeBetween(Long ownerId, LocalDateTime startDateTime, LocalDateTime endDateTime);
}
