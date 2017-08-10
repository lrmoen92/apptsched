package apptsched.rest;

import apptsched.domain.Employee;
import apptsched.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeRest {


    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRest(EmployeeService employeeService){
        this.employeeService = employeeService;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Employee> getAllEmployees(){
        return employeeService.findAll();
    }

    @RequestMapping(value = "/", params = {"email"}, method = RequestMethod.GET)
    public Employee getEmployeeByEmail(@RequestParam(value = "email") String email){
        return employeeService.findByEmail(email);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable int id){
        return employeeService.findOne(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean deleteEmployee(@PathVariable int id){
        boolean result = false;
        try{
            employeeService.delete(id);
            result = true;
        }catch(Exception ex){
            return result;
        }
        return result;
    }
}
