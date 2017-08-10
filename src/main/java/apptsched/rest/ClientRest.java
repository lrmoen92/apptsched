package apptsched.rest;

import apptsched.domain.Client;
import apptsched.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/client")
public class ClientRest {


    private final ClientService clientService;

    @Autowired
    public ClientRest(ClientService clientService){
        this.clientService = clientService;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Client> getAllClients(){
        return clientService.findAll();
    }

    @RequestMapping(value = "/", params = {"email"}, method = RequestMethod.GET)
    public Client getClientByEmail(@RequestParam(value = "email") String email){
        return  clientService.findByEmail(email);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Client getClientById(@PathVariable int id){
        return clientService.findOne(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Client saveClient(@RequestBody Client client){
        return clientService.save(client);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean deleteClient(@PathVariable int id){
        boolean result = false;
        try{
            clientService.delete(id);
            result = true;
        }catch(Exception ex){
            return result;
        }
        return result;
    }
}