package eg.bazinga.scheduler.domins;

import java.util.HashSet;
import java.util.Set;

public class UnitType extends Unit {

    private Set<SubUnitType> subUnitTypes;

    public Set<SubUnitType> getSubUnitTypes() {
        if (subUnitTypes == null) {
            subUnitTypes = new HashSet<>();
        }
        return subUnitTypes;
    }

    public void setSubUnitTypes(Set<SubUnitType> subUnitTypes) {
        this.subUnitTypes = subUnitTypes;
    }
}
