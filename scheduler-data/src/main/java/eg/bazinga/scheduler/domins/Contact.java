package eg.bazinga.scheduler.domins;

import eg.bazinga.scheduler.domins.enums.ContactType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CONTACTS")
@Getter
@Setter
public class Contact extends Person {

    @Column(name = "JOB_TITLE")
    private String jobTitle;

    @Enumerated(value = EnumType.STRING)
    private ContactType contactType;

}
