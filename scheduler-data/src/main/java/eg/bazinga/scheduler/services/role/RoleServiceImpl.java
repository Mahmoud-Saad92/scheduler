package eg.bazinga.scheduler.services.role;

import eg.bazinga.scheduler.domins.Role;
import eg.bazinga.scheduler.domins.enums.ERole;
import eg.bazinga.scheduler.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> findByName(ERole roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
