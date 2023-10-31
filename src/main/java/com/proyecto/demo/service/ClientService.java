package com.proyecto.demo.service;

import com.proyecto.demo.entity.Client;
import com.proyecto.demo.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Client createClient(Client client) throws Exception {
        validate(client.getName(), client.getLastName(), client.getDocNumber());

        clientRepository.save(client);
        return client;
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public Client getClientById(Integer id) throws Exception {
        Optional<Client> client = clientRepository.findById(id);

        if (client.isPresent()){
            return client.get();
        }else {
            throw new Exception("Client not found");
        }
    }

    @Transactional
    public Client modifyClient(Integer id, Client client) throws Exception{
        validate(client.getName(), client.getLastName(), client.getDocNumber());
        Client modifiedClient = getClientById(id);

        modifiedClient.setName(client.getName());
        modifiedClient.setLastName(client.getLastName());
        modifiedClient.setDocNumber(client.getDocNumber());

        clientRepository.save(modifiedClient);
        return modifiedClient;
    }
    @Transactional
    public Client deleteClientById(Integer id) throws Exception {
        Client client = getClientById(id);
        clientRepository.delete(client);
        return client;
    }

    private void validate(String name, String lastName, String docNumber) throws Exception {

        if (name.isBlank()){
            throw new Exception("Empty name");
        } else if (name.length()>30) {
            throw new Exception("Name too long");
        }

        if (lastName.isBlank()){
            throw new Exception("Empty Last Name");
        } else if (lastName.length()>30) {
            throw new Exception("Last Name too long");
        }

        if (docNumber.isBlank()){
            throw new Exception("Empty document");
        }
    }
}
