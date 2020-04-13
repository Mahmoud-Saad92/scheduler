package eg.bazinga.scheduler.repositories;

import eg.bazinga.scheduler.domins.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser, Long> {

    Optional<SystemUser> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmailAddress(String email);

}
