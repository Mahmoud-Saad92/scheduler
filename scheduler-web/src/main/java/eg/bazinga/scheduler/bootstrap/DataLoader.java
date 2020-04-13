package eg.bazinga.scheduler.bootstrap;

import eg.bazinga.scheduler.domins.Contact;
import eg.bazinga.scheduler.domins.SubUnitType;
import eg.bazinga.scheduler.domins.SystemUser;
import eg.bazinga.scheduler.domins.UnitType;
import eg.bazinga.scheduler.domins.enums.ContactType;
import eg.bazinga.scheduler.domins.enums.Type;
import eg.bazinga.scheduler.services.appointment.AppointmentService;
import eg.bazinga.scheduler.services.appointment.attachment.AppointmentAttachmentService;
import eg.bazinga.scheduler.services.appointment.attendee.AppointmentAttendeeService;
import eg.bazinga.scheduler.services.contact.ContactService;
import eg.bazinga.scheduler.services.sub.unit.type.SubUnitTypeService;
import eg.bazinga.scheduler.services.unit.type.UnitTypeService;
import eg.bazinga.scheduler.services.user.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class DataLoader implements CommandLineRunner {

    private UnitTypeService unitTypeServiceImpl;
    private SubUnitTypeService subUnitTypeServiceImpl;
    private SystemUserService systemUserServiceImpl;
    private ContactService contactServiceImpl;
    private AppointmentService appointmentServiceImpl;
    private AppointmentAttachmentService appointmentAttachmentServiceImpl;
    private AppointmentAttendeeService appointmentAttendeeServiceImpl;

    @Autowired
    public DataLoader(UnitTypeService unitTypeServiceImpl,
                      SubUnitTypeService subUnitTypeServiceImpl, SystemUserService systemUserServiceImpl,
                      ContactService contactServiceImpl,
                      AppointmentService appointmentServiceImpl,
                      AppointmentAttachmentService appointmentAttachmentServiceImpl,
                      AppointmentAttendeeService appointmentAttendeeServiceImpl) {

        this.unitTypeServiceImpl = unitTypeServiceImpl;
        this.subUnitTypeServiceImpl = subUnitTypeServiceImpl;
        this.systemUserServiceImpl = systemUserServiceImpl;
        this.contactServiceImpl = contactServiceImpl;
        this.appointmentServiceImpl = appointmentServiceImpl;
        this.appointmentAttachmentServiceImpl = appointmentAttachmentServiceImpl;
        this.appointmentAttendeeServiceImpl = appointmentAttendeeServiceImpl;
    }

    @Override
    public void run(String... args) throws Exception {
        if (unitTypeServiceImpl.findAll().isEmpty()) {
            initUnitTypes();
        }
    }

    @Transactional
    public void initUnitTypes() {

        UnitType unitType =
                UnitType
                        .builder()
                        .type(Type.PARENT)
                        .active(true)
                        .name("IT")
                        .build();

        unitTypeServiceImpl.save(unitType);

        SubUnitType subUnitTypeOne =
                SubUnitType
                        .builder()
                        .active(true)
                        .name("RND")
                        .type(Type.CHILD)
                        .unitType(unitType)
                        .build();

        subUnitTypeServiceImpl.save(subUnitTypeOne);

        SubUnitType subUnitTypeTwo =
                SubUnitType
                        .builder()
                        .active(true)
                        .name("SUPPORT")
                        .type(Type.CHILD)
                        .unitType(unitType)
                        .build();

        subUnitTypeServiceImpl.save(subUnitTypeTwo);

        unitType.getSubUnitTypes().forEach(subUnitType -> {
            System.out.println(subUnitType.getName());
        });

        unitTypeServiceImpl.save(unitType);

        Contact contactOne =
                Contact
                        .builder()
                        .contactType(ContactType.INTERNAL)
                        .active(true)
                        .jobTitle("Developer")
                        .name("Mahmoud")
                        .emailAddress("m.saad@gmail.com")
                        .unitType(unitType)
                        .subUnitType(subUnitTypeOne)
                        .phoneNumber("01096942732")
                        .build();

        contactServiceImpl.save(contactOne);

        Contact contactTwo =
                Contact
                        .builder()
                        .contactType(ContactType.EXTERNAL)
                        .active(false)
                        .jobTitle("System Admin")
                        .name("Hassan")
                        .emailAddress("s.hassan@gmail.com")
                        .unitType(unitType)
                        .subUnitType(subUnitTypeTwo)
                        .phoneNumber("010853717432")
                        .build();

        contactServiceImpl.save(contactTwo);

        SystemUser user =
                SystemUser
                        .builder()
                        .active(true)
                        .currentView("month")
                        .lastViewOwnerId(1l)
                        .username("msaad")
                        .password("qwerty".chars().mapToObj(c -> (char) c).toArray(Character[]::new))
                        .phoneNumber("01096942732")
                        .name("saad")
                        .emailAddress("m.saad@gmail.com")
                        .contact(contactOne)
                        .unitType(unitType)
                        .subUnitType(subUnitTypeOne)
                        .build();

        systemUserServiceImpl.save(user);
    }
}
