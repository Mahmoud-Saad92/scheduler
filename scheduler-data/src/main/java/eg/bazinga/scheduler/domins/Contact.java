package eg.bazinga.scheduler.domins;

import eg.bazinga.scheduler.domins.enums.ContactType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "CONTACTS")
@Getter
@Setter
public class Contact extends Person implements Serializable {

    @Column(name = "JOB_TITLE")
    private String jobTitle;

    @Enumerated(value = EnumType.STRING)
    private ContactType contactType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contact", orphanRemoval = true)
    private Set<AppointmentAttendee> attendees;

}
