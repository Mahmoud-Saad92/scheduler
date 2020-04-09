package eg.bazinga.scheduler.domins;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "APPOINTMENT_ATTENDEES")
@Getter
@Setter
public class AppointmentAttendee extends AuditEntity implements Serializable {

    @EmbeddedId
    private AppointmentAttendeeKey id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("APPOINTMENT_ID")
    @JoinColumn(name = "APPOINTMENT_ID")
    private Appointment appointment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("CONTACT_ID")
    @JoinColumn(name = "CONTACT_ID")
    private Contact contact;

}
