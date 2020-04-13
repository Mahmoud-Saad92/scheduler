package eg.bazinga.scheduler.services.appointment.attachment;

import eg.bazinga.scheduler.domins.AppointmentAttachment;
import eg.bazinga.scheduler.exceptions.IExceptionMessage;
import eg.bazinga.scheduler.repositories.AppointmentAttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AppointmentAttachmentServiceImpl implements AppointmentAttachmentService {

    private AppointmentAttachmentRepository appointmentAttachmentRepository;

    @Autowired
    public AppointmentAttachmentServiceImpl(AppointmentAttachmentRepository appointmentAttachmentRepository) {
        this.appointmentAttachmentRepository = appointmentAttachmentRepository;
    }

    @Override
    public Set<AppointmentAttachment> findAll() {
        HashSet<AppointmentAttachment> appointmentAttachments = new HashSet<>();
        appointmentAttachmentRepository.findAll().iterator().forEachRemaining(appointmentAttachments::add);

        return appointmentAttachments;
    }

    @Override
    public AppointmentAttachment save(AppointmentAttachment appointmentAttachment) {
        return appointmentAttachmentRepository.save(appointmentAttachment);
    }

    @Override
    public AppointmentAttachment findById(Long id) {
        return appointmentAttachmentRepository.findById(id).orElseThrow(() -> new RuntimeException(IExceptionMessage.NOT_FOUND));
    }

    @Override
    public void delete(AppointmentAttachment appointmentAttachment) {
        appointmentAttachmentRepository.delete(appointmentAttachment);
    }

    @Override
    public void deleteById(Long id) {
        appointmentAttachmentRepository.deleteById(id);
    }
}
