package eg.bazinga.scheduler.domins;

import eg.bazinga.scheduler.domins.enums.Priority;
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
@Table(name = "APPOINTMENTS")
@Getter
@Setter
@NoArgsConstructor
public class Appointment extends BaseEntity implements Serializable {

    @Enumerated(EnumType.STRING)
    @Column(name = "PRIORITY")
    private Priority priority;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appointment")
    private Set<AppointmentAttachment> attachments;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appointment")
    private Set<AppointmentAttendee> attendees;

    @Builder
    public Appointment(Long id, String createdBy, LocalDateTime createdDate, String updatedBy, LocalDateTime updatedDate,
                       Priority priority, Set<AppointmentAttachment> attachments, Set<AppointmentAttendee> attendees) {
        super(id, createdBy, createdDate, updatedBy, updatedDate);
        this.priority = priority;
        this.attachments = attachments;
        this.attendees = attendees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Appointment that = (Appointment) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
