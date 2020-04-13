package eg.bazinga.scheduler.repositories;

import eg.bazinga.scheduler.domins.SubUnitType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubUnitTypeRepository extends JpaRepository<SubUnitType, Long> {
}
