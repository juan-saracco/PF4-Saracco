package com.proyecto.demo.service;

import com.proyecto.demo.entity.Client;
import com.proyecto.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void createClient(Client client){
        clientRepository.save(client);
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

    public void deleteClientById(Integer id) throws Exception {
        Client client = getClientById(id);
        clientRepository.delete(client);
    }
}
