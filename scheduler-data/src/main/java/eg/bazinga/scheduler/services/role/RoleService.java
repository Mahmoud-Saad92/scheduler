package eg.bazinga.scheduler.services.role;

import eg.bazinga.scheduler.domins.Role;
import eg.bazinga.scheduler.domins.enums.ERole;

import java.util.Optional;

public interface RoleService {

    Optional<Role> findByName(ERole roleName);

    Role save(Role role);
}
