package com.proyecto.demo.controller;

import com.proyecto.demo.entity.Client;
import com.proyecto.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/client")
    public ResponseEntity<List<Client>> getClients(){
        List<Client> clients = clientService.getClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Integer id) throws Exception {
        Client client = clientService.getClientById(id);
        return ResponseEntity.ok(client);
    }

    @PostMapping("/client")
    public ResponseEntity<Client> postClient(@RequestBody Client client){
        clientService.createClient(client);
        return ResponseEntity.ok(client);
    }

    @PostMapping("client/{id}")
    public void deleteClient(@PathVariable Integer id) throws Exception {
        clientService.deleteClientById(id);
    }

}
