package eg.bazinga.scheduler.domins;

import eg.bazinga.scheduler.domins.enums.ContactType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "CONTACTS")
@Getter
@Setter
@NoArgsConstructor
public class Contact extends Person implements Serializable {

    @Column(name = "JOB_TITLE")
    private String jobTitle;

    @Enumerated(value = EnumType.STRING)
    private ContactType contactType;

    @OneToOne(mappedBy = "contact")
    private SystemUser systemUser;

    @OneToMany(mappedBy = "contact")
    private Set<AppointmentAttendee> attendees;

    @Builder
    public Contact(Long id, String createdBy, LocalDateTime createdDate, String updatedBy, LocalDateTime updatedDate,
                   String name, String emailAddress, String phoneNumber, Boolean active, UnitType unitType,
                   SubUnitType subUnitType, String jobTitle, ContactType contactType) {
        super(id, createdBy, createdDate, updatedBy, updatedDate, name, emailAddress, phoneNumber, active,
                unitType, subUnitType);
        this.jobTitle = jobTitle;
        this.contactType = contactType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Contact that = (Contact) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
