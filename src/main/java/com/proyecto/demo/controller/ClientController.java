package com.proyecto.demo.controller;

import com.proyecto.demo.entity.Client;
import com.proyecto.demo.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Operation(summary = "Obtener clientes", description = "Nos permite obtener la lista de clientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa"),
            @ApiResponse(responseCode = "400", description = "Peticion incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se encontro ningun cliente" ,
            content = {
                    @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Error.class))})
    })
    @GetMapping(value = "/client")
    public ResponseEntity<List<Client>> getClients(){
        List<Client> clients = clientService.getClients();
        return ResponseEntity.ok(clients);
    }

    @Operation(summary = "Obtener cliente", description = "Nos permite obtener cliente por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa"),
            @ApiResponse(responseCode = "400", description = "Peticion incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se encontro ningun cliente con el ID indicado" ,
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Error.class))})
    })
    @GetMapping(value = "/client/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Integer id) throws Exception {
        Client client = clientService.getClientById(id);
        return ResponseEntity.ok(client);
    }

    @Operation(summary = "Crear cliente", description = "Nos permite crear un nuevo cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa"),
            @ApiResponse(responseCode = "400", description = "Peticion incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se pudo crear el cliente" ,
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Error.class))})
    })
    @PostMapping(value = "/client")
    public ResponseEntity<Client> postClient(@RequestBody Client client) throws Exception {
        clientService.createClient(client);
        return ResponseEntity.ok(client);
    }

    @Operation(summary = "Modificar cliente", description = "Nos permite modificar un cliente por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa"),
            @ApiResponse(responseCode = "400", description = "Peticion incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se pudo modificar el cliente" ,
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Error.class))})
    })
    @PutMapping(value = "/client/modify/{id}")
    public ResponseEntity<Client> modifyClient(@PathVariable Integer id, @RequestBody Client client) throws Exception {
        clientService.modifyClient(id, client);
        return ResponseEntity.ok(client);
    }

    @Operation(summary = "Borrar cliente", description = "Nos permite borrar un cliente por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa"),
            @ApiResponse(responseCode = "400", description = "Peticion incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se pudo borrar el cliente" ,
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Error.class))})
    })
    @PostMapping(value = "/client/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable Integer id) throws Exception {
        clientService.deleteClientById(id);
        return ResponseEntity.accepted().build();
    }

}
