package eg.bazinga.scheduler.repositories;

import eg.bazinga.scheduler.domins.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
}
