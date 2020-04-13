package eg.bazinga.scheduler.domins;

import eg.bazinga.scheduler.domins.enums.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class Unit extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "IS_ACTIVE")
    private Boolean active;

    @Enumerated(value = EnumType.STRING)
    private Type type;

    public Unit(Long id, String createdBy, LocalDateTime createdDate, String updatedBy, LocalDateTime updatedDate,
                String name, Boolean active, Type type) {
        super(id, createdBy, createdDate, updatedBy, updatedDate);
        this.name = name;
        this.active = active;
        this.type = type;
    }
}
