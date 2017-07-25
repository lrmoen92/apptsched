package apptsched.repositories;

import apptsched.domain.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Logan.Moen on 7/24/2017.
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
