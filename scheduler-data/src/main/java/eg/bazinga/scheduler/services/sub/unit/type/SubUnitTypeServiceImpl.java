package eg.bazinga.scheduler.services.sub.unit.type;

import eg.bazinga.scheduler.domins.SubUnitType;
import eg.bazinga.scheduler.exceptions.IExceptionMessage;
import eg.bazinga.scheduler.repositories.SubUnitTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SubUnitTypeServiceImpl implements SubUnitTypeService {

    private SubUnitTypeRepository subUnitTypeRepository;

    @Autowired
    public SubUnitTypeServiceImpl(SubUnitTypeRepository subUnitTypeRepository) {
        this.subUnitTypeRepository = subUnitTypeRepository;
    }

    @Override
    public Set<SubUnitType> findAll() {
        Set<SubUnitType> subUnitTypes = new HashSet<>();
        subUnitTypeRepository.findAll().iterator().forEachRemaining(subUnitTypes::add);

        return subUnitTypes;
    }

    @Override
    public SubUnitType save(SubUnitType subUnitType) {
        return subUnitTypeRepository.save(subUnitType);
    }

    @Override
    public SubUnitType findById(Long id) {
        return subUnitTypeRepository.findById(id).orElseThrow(() -> new RuntimeException(IExceptionMessage.NOT_FOUND));
    }

    @Override
    public void delete(SubUnitType subUnitType) {
        subUnitTypeRepository.delete(subUnitType);
    }

    @Override
    public void deleteById(Long id) {
        subUnitTypeRepository.deleteById(id);
    }
}
