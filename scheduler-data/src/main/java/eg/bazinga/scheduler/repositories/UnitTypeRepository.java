package eg.bazinga.scheduler.repositories;

import eg.bazinga.scheduler.domins.UnitType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitTypeRepository extends CrudRepository<UnitType, Long> {
}
