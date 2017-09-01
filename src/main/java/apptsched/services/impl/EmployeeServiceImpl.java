package apptsched.services.impl;

import apptsched.domain.Employee;
import apptsched.repositories.EmployeeRepository;
import apptsched.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(Employee object) {
        return employeeRepository.save(object);
    }

    @Override
    public Iterable<Employee> save(Iterable<Employee> objectIterable) {
        return employeeRepository.save(objectIterable);
    }

    @Override
    public Employee findOne(Integer id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public Employee findByEmail(String email) {
        for (Employee e : employeeRepository.findAll()) {
            if (e.getEmailAddress().equals(email)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public boolean exists(Integer id) {
        return employeeRepository.exists(id);
    }

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public long count() {
        return employeeRepository.count();
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.delete(id);
    }

    @Override
    public void delete(Employee object) {
        employeeRepository.delete(object);
    }

    @Override
    public void delete(Iterable<Employee> objectIterable) {
        employeeRepository.delete(objectIterable);
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }

    @Override
    public Iterable<Employee> findAll(Sort var1) {
        return employeeRepository.findAll(var1);
    }

    @Override
    public Page<Employee> findAll(Pageable var1) {
        return employeeRepository.findAll(var1);
    }
}
