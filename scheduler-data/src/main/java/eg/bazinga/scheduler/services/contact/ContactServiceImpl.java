package eg.bazinga.scheduler.services.contact;

import eg.bazinga.scheduler.domins.Contact;
import eg.bazinga.scheduler.exceptions.IExceptionMessage;
import eg.bazinga.scheduler.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Set<Contact> findAll() {
        Set<Contact> contacts = new HashSet<>();
        contactRepository.findAll().iterator().forEachRemaining(contacts::add);

        return contacts;
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact findById(Long id) {
        return contactRepository.findById(id).orElseThrow(() -> new RuntimeException(IExceptionMessage.NOT_FOUND));
    }

    @Override
    public void delete(Contact contact) {
        contactRepository.delete(contact);
    }

    @Override
    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }
}
