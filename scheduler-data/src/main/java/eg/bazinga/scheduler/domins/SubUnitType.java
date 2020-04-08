package eg.bazinga.scheduler.domins;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SUB_UNITS")
@Getter
@Setter
public class SubUnitType extends Unit {

    @ManyToOne
    @JoinColumn(name = "UNIT_ID")
    private UnitType unitType;

}
