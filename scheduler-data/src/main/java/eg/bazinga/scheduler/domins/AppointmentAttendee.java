package eg.bazinga.scheduler.domins;

import eg.bazinga.scheduler.exceptions.IExceptionMessage;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;

@Entity
@Table(name = "APPOINTMENT_ATTENDEES")
@Getter
@Setter
@NoArgsConstructor
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

    @Builder
    public AppointmentAttendee(AppointmentAttendeeKey id, String createdBy, LocalDateTime createdDate, String updatedBy, LocalDateTime updatedDate,
                               Appointment appointment, Contact contact) {
        super(createdBy, createdDate, updatedBy, updatedDate);
        this.id = id;
        this.appointment = appointment;
        this.contact = contact;
    }

    @PostPersist
    private void updateAppointmentAndContact() {
        if (this.id != null && this.id.getAppointmentId() != null && this.id.getContactId() != null && this.appointment != null && this.contact != null) {
            if (this.appointment.getAttendees() == null) {
                this.appointment.setAttendees(new HashSet<>());
            }
            this.appointment.getAttendees().add(this);

            if (this.contact.getAttendees() == null) {
                this.contact.setAttendees(new HashSet<>());
            }
            this.contact.getAttendees().add(this);
        }
    }

    public AppointmentAttendeeKey getId() {
        if (id == null && appointment != null && appointment.getId() != null && contact != null && contact.getId() != null) {
            id = AppointmentAttendeeKey
                    .builder()
                    .appointmentId(this.appointment.getId())
                    .contactId(this.contact.getId())
                    .build();
        } else {
            throw new RuntimeException(IExceptionMessage.ATTENDEE_MISSING_KEY);
        }
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppointmentAttendee that = (AppointmentAttendee) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
