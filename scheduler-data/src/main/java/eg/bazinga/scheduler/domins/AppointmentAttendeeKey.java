package eg.bazinga.scheduler.domins;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class AppointmentAttendeeKey implements Serializable {

    @Column(name = "APPOINTMENT_ID")
    private Long appointmentId;

    @Column(name = "CONTACT_ID")
    private Long contactId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppointmentAttendeeKey that = (AppointmentAttendeeKey) o;
        return Objects.equals(appointmentId, that.appointmentId) && Objects.equals(contactId, that.contactId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId, contactId);
    }
}
