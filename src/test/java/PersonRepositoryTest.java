import apptsched.configuration.RepositoryConfiguration;
import apptsched.domain.Person;
import apptsched.repositories.PersonRepository;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testRetrievePerson(){

        Person person = new Person("This", "Is", "A", "Test", "@email.com");
        assertNull(person.getId());
        personRepository.save(person);
        assertNotNull(person.getId());

        Person person2 = personRepository.findOne(15);
        person2.setMiddleName("Dude");
        personRepository.save(person2);

    }
}
