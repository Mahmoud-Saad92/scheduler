package eg.bazinga.scheduler.repositories;

import eg.bazinga.scheduler.domins.AppointmentAttachment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentAttachmentRepository extends CrudRepository<AppointmentAttachment, Long> {
}
