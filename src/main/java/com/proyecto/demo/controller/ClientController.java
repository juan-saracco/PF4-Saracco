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
    private ResponseEntity<List<Client>> getClients(){
        List<Client> clients = clientService.getClients();

        return ResponseEntity.ok(clients);
    }

    @PostMapping("/client")
    private ResponseEntity<Client> postClient(@RequestBody Client client){
        clientService.createClient(client);
        return ResponseEntity.ok(client);
    }

    @PostMapping("client/{id}")
    private void deleteClient(@PathVariable Integer id) throws Exception {
        clientService.deleteClientById(id);

    }


}
