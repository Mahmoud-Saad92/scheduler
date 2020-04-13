package eg.bazinga.scheduler.repositories;

import eg.bazinga.scheduler.domins.Role;
import eg.bazinga.scheduler.domins.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleName(ERole roleName);
}
