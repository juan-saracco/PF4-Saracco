package com.proyecto.demo.controller;

import com.proyecto.demo.entity.Invoice;
import com.proyecto.demo.service.InvoiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;


    @Operation(summary = "Obtener invoices", description = "Nos permite obtener la lista de invoices")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa"),
            @ApiResponse(responseCode = "400", description = "Peticion incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se encontro ningun invoice" ,
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Error.class))})
    })
    @GetMapping("/invoice")
    public ResponseEntity<List<Invoice>> getInvoices(){
        List<Invoice> invoices = invoiceService.getInvoices();
        return ResponseEntity.ok(invoices);
    }

    @Operation(summary = "Obtener invoice", description = "Nos permite obtener el invoice")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa"),
            @ApiResponse(responseCode = "400", description = "Peticion incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se encontro ningun invoice con ese ID" ,
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Error.class))})
    })
    @GetMapping("/invoice/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Integer id) throws Exception {
        Invoice invoice = invoiceService.getInvoiceById(id);
        return ResponseEntity.ok(invoice);
    }

    @Operation(summary = "Crear invoice", description = "Nos permite crear un invoice")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa"),
            @ApiResponse(responseCode = "400", description = "Peticion incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se pudo crear el invoice" ,
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Error.class))})
    })
    @PostMapping("/invoice")
    public ResponseEntity<Invoice> postInvoice(@RequestBody Invoice invoice) throws Exception {
        invoiceService.createInvoice(invoice);
        return ResponseEntity.ok(invoice);
    }

    @Operation(summary = "Borrar invoice", description = "Nos permite borrar un invoice por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa"),
            @ApiResponse(responseCode = "400", description = "Peticion incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se pudo borrar el invoice" ,
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Error.class))})
    })
    @PostMapping("/invoice/{id}")
    public void deleteInvoiceById(@PathVariable Integer id) throws Exception {
        invoiceService.deleteInvoiceById(id);
    }
}
