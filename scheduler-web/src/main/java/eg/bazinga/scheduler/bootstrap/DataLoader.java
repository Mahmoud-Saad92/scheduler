package eg.bazinga.scheduler.bootstrap;

import eg.bazinga.scheduler.domins.Contact;
import eg.bazinga.scheduler.domins.SubUnitType;
import eg.bazinga.scheduler.domins.SystemUser;
import eg.bazinga.scheduler.domins.UnitType;
import eg.bazinga.scheduler.domins.enums.ContactType;
import eg.bazinga.scheduler.domins.enums.Type;
import eg.bazinga.scheduler.services.contact.ContactService;
import eg.bazinga.scheduler.services.unit.type.UnitTypeService;
import eg.bazinga.scheduler.services.user.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private UnitTypeService unitTypeServiceImpl;
    private SystemUserService systemUserServiceImpl;
    private ContactService contactServiceImpl;

    @Autowired
    public DataLoader(UnitTypeService unitTypeServiceImpl,
                      SystemUserService systemUserServiceImpl,
                      ContactService contactServiceImpl) {
        
        this.unitTypeServiceImpl = unitTypeServiceImpl;
        this.systemUserServiceImpl = systemUserServiceImpl;
        this.contactServiceImpl = contactServiceImpl;
    }

    @Override
    public void run(String... args) throws Exception {
        if (unitTypeServiceImpl.findAll().isEmpty()) {
            initUnitTypes ();
        }
    }

    @Transactional
    public void initUnitTypes () {
        UnitType unitType = new UnitType();
        unitType.setName("IT");
        unitType.setActive(true);
        unitType.setType(Type.PARENT);
        
        SubUnitType subUnitTypeOne = new SubUnitType();
        subUnitTypeOne.setUnitType(unitType);
        subUnitTypeOne.setName("SUPPORT");
        subUnitTypeOne.setActive(true);
        subUnitTypeOne.setType(Type.CHILD);

        SubUnitType subUnitTypeTwo = new SubUnitType();
        subUnitTypeTwo.setUnitType(unitType);
        subUnitTypeTwo.setName("RND");
        subUnitTypeTwo.setActive(true);
        subUnitTypeTwo.setType(Type.CHILD);

        Set<SubUnitType> subUnitTypes = new HashSet<>();
        subUnitTypes.add(subUnitTypeOne);
        subUnitTypes.add(subUnitTypeTwo);

        unitType.setSubUnitTypes(subUnitTypes);

        unitTypeServiceImpl.save(unitType);

        Contact contactOne = new Contact();
        contactOne.setContactType(ContactType.INTERNAL);
        contactOne.setJobTitle("Developer");
        contactOne.setName("Mahmoud");
        contactOne.setActive(true);
        contactOne.setEmailAddress("m.saad@gmail.com");
        contactOne.setPhoneNumber("01096942732");
        contactOne.setUnitType(unitType);
        contactOne.setSubUnitType(subUnitTypeTwo);
        
        contactServiceImpl.save(contactOne);

        Contact contactTwo = new Contact();
        contactTwo.setContactType(ContactType.EXTERNAL);
        contactTwo.setJobTitle("Developer");
        contactTwo.setName("Hassan");
        contactTwo.setActive(false);
        contactTwo.setEmailAddress("s.hassan@gmail.com");
        contactTwo.setPhoneNumber("010853717432");
        contactTwo.setUnitType(unitType);
        contactTwo.setSubUnitType(subUnitTypeOne);

        contactServiceImpl.save(contactTwo);

        SystemUser user = new SystemUser();
        user.setCurrentView("month");
        user.setLastViewOwnerId(1l);
        user.setUsername("msaad");
        user.setPassword("qwerty".toCharArray());
        user.setContact(contactOne);
        user.setActive(true);
        user.setName("Mahmoud");
        user.setPhoneNumber("01096942732");
        user.setEmailAddress("m.saad@gmail.com");
        user.setUnitType(unitType);
        user.setSubUnitType(subUnitTypeTwo);

        systemUserServiceImpl.save(user);
    }
}
