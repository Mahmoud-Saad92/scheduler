package eg.bazinga.scheduler.domins;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class BaseEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public BaseEntity(Long id, String createdBy, LocalDateTime createdDate, String updatedBy, LocalDateTime updatedDate) {
        super(createdBy, createdDate, updatedBy, updatedDate);
        this.id = id;
    }

}
