package ua.foxminded.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.foxminded.common.model.entity.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long>{

    Owner save(Owner owner);
}
