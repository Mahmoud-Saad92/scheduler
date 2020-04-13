package eg.bazinga.scheduler.services.user;

import eg.bazinga.scheduler.domins.SystemUser;
import eg.bazinga.scheduler.exceptions.IExceptionMessage;
import eg.bazinga.scheduler.repositories.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SystemUserServiceImpl implements SystemUserService {

    private SystemUserRepository systemUserRepository;

    @Autowired
    public SystemUserServiceImpl(SystemUserRepository systemUserRepository) {
        this.systemUserRepository = systemUserRepository;
    }

    @Override
    public Set<SystemUser> findAll() {
        Set<SystemUser> systemUsers = new HashSet<>();
        systemUserRepository.findAll().iterator().forEachRemaining(systemUsers::add);

        return systemUsers;
    }

    @Override
    public SystemUser save(SystemUser systemUser) {
        return systemUserRepository.save(systemUser);
    }

    @Override
    public SystemUser findById(Long id) {
        return systemUserRepository.findById(id).orElseThrow(() -> new RuntimeException(IExceptionMessage.NOT_FOUND));
    }

    @Override
    public void delete(SystemUser systemUser) {
        systemUserRepository.delete(systemUser);
    }

    @Override
    public void deleteById(Long id) {
        systemUserRepository.deleteById(id);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return systemUserRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return systemUserRepository.existsByEmailAddress(email);
    }
}
