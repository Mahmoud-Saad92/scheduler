package eg.bazinga.scheduler.repositories;

import eg.bazinga.scheduler.domins.AppointmentAttendee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentAttendeeRepository extends CrudRepository<AppointmentAttendee, Long> {
}
