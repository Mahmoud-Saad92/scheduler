package eg.bazinga.scheduler.domins;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "APPOINTMENT_ATTACHMENTS")
@Getter
@Setter
public class AppointmentAttachment extends BaseEntity implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "APPOINTMENT_ID")
    private Appointment appointment;

}
