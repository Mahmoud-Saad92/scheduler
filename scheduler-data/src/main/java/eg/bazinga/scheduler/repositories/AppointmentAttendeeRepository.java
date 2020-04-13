package eg.bazinga.scheduler.repositories;

import eg.bazinga.scheduler.domins.AppointmentAttendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentAttendeeRepository extends JpaRepository<AppointmentAttendee, Long> {
}
