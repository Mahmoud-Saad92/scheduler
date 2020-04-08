package eg.bazinga.scheduler.domins;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "UNITS")
@Getter
@Setter
public class UnitType extends Unit {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitType")
    private Set<SubUnitType> subUnitTypes;

    public Set<SubUnitType> getSubUnitTypes() {
        if (subUnitTypes == null) {
            subUnitTypes = new HashSet<>();
        }
        return subUnitTypes;
    }

}
