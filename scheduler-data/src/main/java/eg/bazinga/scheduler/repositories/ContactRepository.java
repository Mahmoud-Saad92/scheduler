package eg.bazinga.scheduler.repositories;

import eg.bazinga.scheduler.domins.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
