package ua.foxminded.domain.activity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.foxminded.domain.activity.model.entity.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long>{

    Activity save(Activity activity);

}
