package apptsched.services;

import apptsched.domain.Employee;

public interface EmployeeService {

    Employee save(Employee object);

    Iterable<Employee> save(Iterable<Employee> objectIterable);

    Employee findOne(Integer id);

    Employee findByEmail(String email);

    boolean exists(Integer id);

    Iterable<Employee> findAll();

    long count();

    void delete(Integer id);

    void delete(Employee object);

    void delete(Iterable<Employee> objectIterable);

    void deleteAll();
}