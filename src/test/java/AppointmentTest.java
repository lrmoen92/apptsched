import apptsched.common.DateHelper;
import apptsched.domain.Appointment;
import apptsched.domain.Client;
import apptsched.domain.Employee;
import apptsched.repositories.AppointmentRepository;
import apptsched.services.AppointmentService;
import apptsched.services.impl.AppointmentServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AppointmentTest {

    @Test
    public void testRetrieveAppointment(){

        AppointmentRepository appointmentRepositoryMock = mock(AppointmentRepository.class);

        Appointment appt = new Appointment("Meeting", "10/2/2017", "FD33", new Employee(), new Client());
        Appointment appt2 = new Appointment("Consulting", "10/2/2017", "FD33", new Employee(), new Client());

        List<Appointment> mockedList = new ArrayList<>();
        mockedList.add(appt);
        mockedList.add(appt2);

        when(appointmentRepositoryMock.findAll()).thenReturn(mockedList);

        AppointmentServiceImpl appointmentServiceImpl = new AppointmentServiceImpl(appointmentRepositoryMock);

        Iterable<Appointment> foundIterable = appointmentServiceImpl.findAll();
        List<Appointment> foundList = new ArrayList<>();
        foundIterable.forEach(foundList::add);

        assertEquals(2, foundList.size());
        assertEquals(null, foundList.get(0).getClient().getFirstName());
        assertEquals("Consulting", foundList.get(1).getType());

    }
}
