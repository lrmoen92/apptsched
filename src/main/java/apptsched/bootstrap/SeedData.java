package apptsched.bootstrap;

import apptsched.common.DateHelper;
import apptsched.domain.Appointment;
import apptsched.domain.Client;
import apptsched.domain.Employee;
import apptsched.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Logan.Moen on 7/24/2017.
 */
@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
        method1();
    }

    public void method1(){

        List<Date> e1PTO = new ArrayList<>();
        e1PTO.add(DateHelper.dateConstructor(1995, 1, 1, false));
        e1PTO.add(DateHelper.dateConstructor(1995, 1, 2, false));

        Employee employee1 = new Employee("Logan", "Moen", "Robert", "lrmoen@gmail.com", "952-929-2233",
                DateHelper.dateConstructor(1992, 1, 1, false),
                "Doctor");
        Client client1 = new Client("Andrew", "Warnke", "Christopher", "acwarnke@gmail.com", "952-929-2234",
                DateHelper.dateConstructor(1992, 3, 3, false)
        );

        employee1.setPto(e1PTO);


        employeeRepository.save(employee1);
        clientRepository.save(client1);

        List<Appointment> e1Appt = new ArrayList<>();
        Appointment appt1 = new Appointment("Meeting", DateHelper.dateConstructor(2000, 1, 1, false), "F204", employee1, client1);
        Appointment appt2 = new Appointment("Check-Up", DateHelper.dateConstructor(2004, 1, 1, false), "F209", employee1, client1);
        e1Appt.add(appt1);
        e1Appt.add(appt2);

        appointmentRepository.save(e1Appt);

        List<Appointment> foundList = new ArrayList<>();
        for(int i = 1; i <= appointmentRepository.count(); i++){
            if(appointmentRepository.findOne(i).getEmployee().getId()
                    .equals
                            (employeeRepository.findOne(1).getId()))
            {
                foundList.add(appointmentRepository.findOne(i));
            }
        }

        Employee foundEmployee = employeeRepository.findOne(1);
        foundEmployee.setAppointmentHistory(foundList);
        employeeRepository.save(foundEmployee);

    }
}
