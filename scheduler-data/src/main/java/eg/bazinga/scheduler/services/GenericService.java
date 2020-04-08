package eg.bazinga.scheduler.services;

import java.util.Set;

public interface GenericService<T, ID> {

    Set<T> findAll();

    T save(T t);

    T findById(ID id);

    void delete(T t);

    void deleteById(ID id);
}
