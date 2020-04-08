package eg.bazinga.scheduler.repositories;

import eg.bazinga.scheduler.domins.SystemUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserRepository extends CrudRepository<SystemUser, Long> {
}
