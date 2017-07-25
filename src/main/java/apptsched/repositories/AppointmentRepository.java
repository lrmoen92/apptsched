package apptsched.repositories;

import apptsched.domain.Appointment;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Logan.Moen on 7/24/2017.
 */
public interface AppointmentRepository extends CrudRepository<Appointment, Integer>{
}
