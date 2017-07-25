package apptsched.repositories;

import apptsched.domain.Client;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Logan.Moen on 7/24/2017.
 */
public interface ClientRepository extends CrudRepository<Client, Integer> {
}
