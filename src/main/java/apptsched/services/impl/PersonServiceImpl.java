package apptsched.services.impl;

import apptsched.domain.Person;
import apptsched.repositories.PersonRepository;
import apptsched.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    public Person save(Person object) {
        return personRepository.save(object);
    }

    @Override
    public Iterable<Person> save(Iterable<Person> objectIterable) {
        return personRepository.save(objectIterable);
    }

    @Override
    public Person findOne(Integer id) {
        return personRepository.findOne(id);
    }

    @Override
    public boolean exists(Integer id) {
        return personRepository.exists(id);
    }

    @Override
    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public long count() {
        return personRepository.count();
    }

    @Override
    public void delete(Integer id) {
        personRepository.delete(id);
    }

    @Override
    public void delete(Person object) {
        personRepository.delete(object);
    }

    @Override
    public void delete(Iterable<Person> objectIterable) {
        personRepository.delete(objectIterable);
    }

    @Override
    public void deleteAll() {
        personRepository.deleteAll();
    }
}
