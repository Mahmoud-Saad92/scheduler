package eg.bazinga.scheduler.domins;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "UNITS")
@Getter
@Setter
public class UnitType extends Unit implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitType", orphanRemoval = true)
    private Set<SubUnitType> subUnitTypes;

}
