package apptsched.rest;

import apptsched.domain.Appointment;
import apptsched.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentRest {


    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentRest(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Appointment> getApptList(){
        return appointmentService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Appointment getAppt(@PathVariable int id){
        return appointmentService.findOne(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Appointment postAppt(@RequestBody Appointment appointment){
        return appointmentService.save(appointment);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean deleteAppt(@PathVariable int id){
        Boolean result = false;
        try{
            appointmentService.delete(id);
            result = true;
        }catch(Exception ex){
            return result;
        }
        return result;
    }

}
