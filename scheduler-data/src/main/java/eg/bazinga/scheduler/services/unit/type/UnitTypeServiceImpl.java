package eg.bazinga.scheduler.services.unit.type;

import eg.bazinga.scheduler.domins.UnitType;
import eg.bazinga.scheduler.exceptions.IExceptionMessage;
import eg.bazinga.scheduler.repositories.UnitTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UnitTypeServiceImpl implements UnitTypeService {

    private UnitTypeRepository unitTypeRepository;

    @Autowired
    public UnitTypeServiceImpl(UnitTypeRepository unitTypeRepository) {
        this.unitTypeRepository = unitTypeRepository;
    }

    @Override
    public Set<UnitType> findAll() {
        Set<UnitType> unitTypes = new HashSet<>();
        unitTypeRepository.findAll().iterator().forEachRemaining(unitTypes::add);

        return unitTypes;
    }

    @Override
    public UnitType save(UnitType unitType) {
        return unitTypeRepository.save(unitType);
    }

    @Override
    public UnitType findById(Long id) {
        return unitTypeRepository.findById(id).orElseThrow(() -> new RuntimeException(IExceptionMessage.NOT_FOUND));
    }

    @Override
    public void delete(UnitType unitType) {
unitTypeRepository.delete(unitType);
    }

    @Override
    public void deleteById(Long id) {
unitTypeRepository.deleteById(id);
    }
}
