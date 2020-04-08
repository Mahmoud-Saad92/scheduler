package eg.bazinga.scheduler.repositories;

import eg.bazinga.scheduler.domins.SubUnitType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubUnitTypeRepository extends CrudRepository<SubUnitType, Long> {
}
