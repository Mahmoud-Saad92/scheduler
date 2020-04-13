package eg.bazinga.scheduler.domins;

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
@Table(name = "APPOINTMENT_ATTACHMENTS")
@Getter
@Setter
@NoArgsConstructor
public class AppointmentAttachment extends BaseEntity implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "APPOINTMENT_ID")
    private Appointment appointment;

    @Builder
    public AppointmentAttachment(Long id, String createdBy, LocalDateTime createdDate, String updatedBy, LocalDateTime updatedDate,
                                 Appointment appointment) {
        super(id, createdBy, createdDate, updatedBy, updatedDate);
        this.appointment = appointment;
    }

    @PostPersist
    private void updateAppointment() {
        if (this.getId() != null && this.appointment != null) {
            if (this.appointment.getAttachments() == null) {
                this.appointment.setAttachments(new HashSet<>());
            }
            this.appointment.getAttachments().add(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppointmentAttachment that = (AppointmentAttachment) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
