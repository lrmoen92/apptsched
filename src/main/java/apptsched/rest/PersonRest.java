package apptsched.rest;

import apptsched.domain.Person;
import apptsched.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/person")
public class PersonRest {

    private final PersonService personService;

    @Autowired
    public PersonRest(PersonService personService){
        this.personService = personService;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Person saveUser(@RequestBody Person person){
        return personService.save(person);
    }
}
