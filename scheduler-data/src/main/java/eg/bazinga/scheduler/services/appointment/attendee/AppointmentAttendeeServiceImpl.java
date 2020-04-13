package eg.bazinga.scheduler.services.appointment.attendee;

import eg.bazinga.scheduler.domins.AppointmentAttendee;
import eg.bazinga.scheduler.exceptions.IExceptionMessage;
import eg.bazinga.scheduler.repositories.AppointmentAttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AppointmentAttendeeServiceImpl implements AppointmentAttendeeService {

    private AppointmentAttendeeRepository appointmentAttendeeRepository;

    @Autowired
    public AppointmentAttendeeServiceImpl(AppointmentAttendeeRepository appointmentAttendeeRepository) {
        this.appointmentAttendeeRepository = appointmentAttendeeRepository;
    }

    @Override
    public Set<AppointmentAttendee> findAll() {
        HashSet<AppointmentAttendee> appointmentAttendees = new HashSet<>();
        appointmentAttendeeRepository.findAll().iterator().forEachRemaining(appointmentAttendees::add);

        return appointmentAttendees;
    }

    @Override
    public AppointmentAttendee save(AppointmentAttendee appointmentAttendee) {
        return appointmentAttendeeRepository.save(appointmentAttendee);
    }

    @Override
    public AppointmentAttendee findById(Long id) {
        return appointmentAttendeeRepository.findById(id).orElseThrow(() -> new RuntimeException(IExceptionMessage.NOT_FOUND));
    }

    @Override
    public void delete(AppointmentAttendee appointmentAttendee) {
        appointmentAttendeeRepository.delete(appointmentAttendee);
    }

    @Override
    public void deleteById(Long id) {
        appointmentAttendeeRepository.deleteById(id);
    }
}
