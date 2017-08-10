package apptsched.bootstrap;

import apptsched.common.DateHelper;
import apptsched.domain.Appointment;
import apptsched.domain.Client;
import apptsched.domain.Employee;
import apptsched.repositories.*;
import apptsched.services.AppointmentService;
import apptsched.services.ClientService;
import apptsched.services.EmployeeService;
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


    private final EmployeeService employeeService;
    private final ClientService clientService;
    private final AppointmentService appointmentService;

    @Autowired
    public SeedData(EmployeeService employeeService, ClientService clientService, AppointmentService appointmentService){
        this.appointmentService = appointmentService;
        this.clientService = clientService;
        this.employeeService = employeeService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
//        method1();
    }

    private void method1(){
//        appointmentService.deleteAll();
//        employeeService.deleteAll();
//        clientService.deleteAll();

        List<Date> e1PTO = new ArrayList<>();
        e1PTO.add(DateHelper.dateConstructor(1995, 1, 1, false));
        e1PTO.add(DateHelper.dateConstructor(1995, 1, 2, false));
        List<Date> e2PTO = new ArrayList<>();
        e1PTO.add(DateHelper.dateConstructor(1996, 1, 1, false));
        e1PTO.add(DateHelper.dateConstructor(1996, 1, 2, false));

        Employee employee1 = new Employee("Logan", "Moen", "Robert", "lrmoen@astontech.com", "952-929-2233",  (DateHelper.dateConstructor(1992, 1, 1, false)), "Doctor");
        Employee employee2 = new Employee("Jay", "Moen", "Andrew", "jamoen@astontech.com", "952-929-2133",  (DateHelper.dateConstructor(1997, 1, 1, false)), "Lawyer");
        Client client1 = new Client("Andrew", "Warnke", "Christopher", "acwarnke@gmail.com", "952-929-2234",  (DateHelper.dateConstructor(1992, 3, 3, false)));
        Client client2 = new Client("Chris", "Warnke", "Rodney", "crwarnke@gmail.com", "952-929-2264",  (DateHelper.dateConstructor(1996, 3, 3, false)));

        employee1.setPto(e1PTO);
        employee1.setPto(e2PTO);


        employeeService.save(employee1);
        employeeService.save(employee2);
        clientService.save(client1);
        clientService.save(client2);

        List<Appointment> e1Appt = new ArrayList<>();
        Appointment appt1 = new Appointment("Meeting", (DateHelper.dateConstructor(2000, 1, 1, false).toString()), "F204", employeeService.findOne(1), clientService.findOne(3));
        Appointment appt2 = new Appointment("Check-Up", (DateHelper.dateConstructor(2004, 1, 1, false).toString()), "F209", employeeService.findOne(2), clientService.findOne(3));
        Appointment appt4 = new Appointment("Review", (DateHelper.dateConstructor(2004, 1, 6, false).toString()), "F209", employeeService.findOne(1), clientService.findOne(3));

        appt1.setCompleted(true);
        appt2.setCompleted(true);

        e1Appt.add(appt1);
        e1Appt.add(appt2);
        e1Appt.add(appt4);

        appointmentService.save(e1Appt);


        Appointment apt = new Appointment("Consulting", new Date().toString(), "F449", employeeService.findOne(1), clientService.findOne(4));
        appointmentService.save(apt);

    }
}
