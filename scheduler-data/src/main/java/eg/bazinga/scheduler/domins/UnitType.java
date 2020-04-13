package eg.bazinga.scheduler.domins;

import eg.bazinga.scheduler.domins.enums.Type;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "UNITS")
@Getter
@Setter
@NoArgsConstructor
public class UnitType extends Unit implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitType")
    private Set<SubUnitType> subUnitTypes;

    @OneToMany(mappedBy = "unitType")
    private Set<SystemUser> systemUsers;

    @OneToMany(mappedBy = "unitType")
    private Set<Contact> contacts;

    @Builder
    public UnitType(Long id, String createdBy, LocalDateTime createdDate, String updatedBy, LocalDateTime updatedDate,
                    String name, Boolean active, Type type, Set<SubUnitType> subUnitTypes) {
        super(id, createdBy, createdDate, updatedBy, updatedDate, name, active, type);
        this.subUnitTypes = subUnitTypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UnitType that = (UnitType) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
