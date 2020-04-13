package eg.bazinga.scheduler.domins;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditEntity {

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DATE")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createdDate;

    @Column(name = "LAST_MODIFIED_BY")
    private String updatedBy;

    @Column(name = "LAST_MODIFIED_DATE")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime updatedDate;

    @PrePersist
    private void setDates() {
        createdDate = LocalDateTime.now();
        updatedDate = LocalDateTime.now();

        if (createdBy == null || createdBy.isEmpty()) {
            setCreatedBy("ADMIN");
        }

        if (updatedBy == null || updatedBy.isEmpty()) {
            setUpdatedBy("ADMIN");
        }
    }

}
