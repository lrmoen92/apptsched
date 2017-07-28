package apptsched.services.impl;

import apptsched.domain.Client;
import apptsched.repositories.ClientRepository;
import apptsched.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client save(Client object) {
        return clientRepository.save(object);
    }

    @Override
    public Iterable<Client> save(Iterable<Client> objectIterable) {
        return clientRepository.save(objectIterable);
    }

    @Override
    public Client findOne(Integer id) {
        return clientRepository.findOne(id);
    }

    @Override
    public boolean exists(Integer id) {
        return clientRepository.exists(id);
    }

    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public long count() {
        return clientRepository.count();
    }

    @Override
    public void delete(Integer id) {
        clientRepository.delete(id);
    }

    @Override
    public void delete(Client object) {
        clientRepository.delete(object);
    }

    @Override
    public void delete(Iterable<Client> objectIterable) {
        clientRepository.delete(objectIterable);
    }

    @Override
    public void deleteAll() {
        clientRepository.deleteAll();
    }
}
