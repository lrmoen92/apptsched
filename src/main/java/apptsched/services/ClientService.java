package apptsched.services;

import apptsched.domain.Client;

public interface ClientService {

    Client save(Client object);

    Iterable<Client> save(Iterable<Client> objectIterable);

    Client findOne(Integer id);

    Client findByEmail(String email);

    boolean exists(Integer id);

    Iterable<Client> findAll();

    long count();

    void delete(Integer id);

    void delete(Client object);

    void delete(Iterable<Client> objectIterable);

    void deleteAll();
}