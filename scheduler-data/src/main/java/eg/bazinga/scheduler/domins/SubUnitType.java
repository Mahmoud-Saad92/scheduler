package eg.bazinga.scheduler.domins;

import eg.bazinga.scheduler.domins.enums.Type;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "SUB_UNITS")
@Getter
@Setter
@NoArgsConstructor
public class SubUnitType extends Unit implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UNIT_ID")
    private UnitType unitType;

    @OneToMany(mappedBy = "subUnitType")
    private Set<SystemUser> systemUsers;

    @OneToMany(mappedBy = "subUnitType")
    private Set<Contact> contacts;

    @Builder
    public SubUnitType(Long id, String createdBy, LocalDateTime createdDate, String updatedBy, LocalDateTime updatedDate,
                       String name, Boolean active, Type type, UnitType unitType) {
        super(id, createdBy, createdDate, updatedBy, updatedDate, name, active, type);
        this.unitType = unitType;
    }

    @PostPersist
    private void updateUnitType() {
        if (this.getId() != null && this.unitType != null) {
            if (this.unitType.getSubUnitTypes() == null) {
                this.unitType.setSubUnitTypes(new HashSet<>());
            }
            this.unitType.getSubUnitTypes().add(this);
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
        SubUnitType that = (SubUnitType) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
