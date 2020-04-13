package eg.bazinga.scheduler.domins;

import eg.bazinga.scheduler.domins.enums.ERole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "ROLES")
@Getter
@Setter
@NoArgsConstructor
public class Role extends BaseEntity implements Serializable {

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE_NAME", length = 20)
    private ERole roleName;

    @Builder
    public Role(Long id, String createdBy, LocalDateTime createdDate, String updatedBy, LocalDateTime updatedDate, ERole roleName) {
        super(id, createdBy, createdDate, updatedBy, updatedDate);
        this.roleName = roleName;
    }
}
