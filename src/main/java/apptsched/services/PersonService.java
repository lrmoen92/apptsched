public interface PersonService {

    Person save(Person object);

    Iterable<Person> save(Iterable<Person> objectIterable);

    Person findOne(Integer id);

    boolean exists(Integer id);

    Iterable<Person> findAll();

    long count();

    void delete(Integer id);

    void delete(Person object);

    void delete(Iterable<Person> objectIterable);

    void deleteAll();
}