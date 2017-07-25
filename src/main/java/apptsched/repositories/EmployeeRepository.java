package apptsched.repositories;

import apptsched.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Logan.Moen on 7/24/2017.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
