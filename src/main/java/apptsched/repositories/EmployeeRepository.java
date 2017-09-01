package apptsched.repositories;

import apptsched.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Logan.Moen on 7/24/2017.
 */
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
}
