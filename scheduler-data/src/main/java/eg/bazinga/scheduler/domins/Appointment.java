package eg.bazinga.scheduler.domins;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "APPOINTMENTS")
@Getter
@Setter
public class Appointment extends BaseEntity implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appointment", orphanRemoval = true)
    private Set<AppointmentAttachment> attachments;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appointment", orphanRemoval = true)
    private Set<AppointmentAttendee> attendees;
}
