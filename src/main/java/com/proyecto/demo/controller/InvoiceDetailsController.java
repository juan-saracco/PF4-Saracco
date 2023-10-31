package com.proyecto.demo.controller;

import com.proyecto.demo.entity.InvoiceDetails;
import com.proyecto.demo.service.InvoiceDetailsService;
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
public class InvoiceDetailsController {

    @Autowired
    private InvoiceDetailsService invoiceDetailsService;


    @Operation(summary = "Obtener los invoiceDetail", description = "Nos permite obtener la lista de invoiceDetail")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa"),
            @ApiResponse(responseCode = "400", description = "Peticion incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se encontro ningun invoiceDetail" ,
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Error.class))})
    })
    @GetMapping("/details")
    public ResponseEntity<List<InvoiceDetails>> getInvoicesDetails(){
        List<InvoiceDetails> invoicesDetails = invoiceDetailsService.getInvoicesDetails();
        return ResponseEntity.ok(invoicesDetails);
    }

    @Operation(summary = "Obtener invoiceDetail", description = "Nos permite obtener un invoiceDetail por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa"),
            @ApiResponse(responseCode = "400", description = "Peticion incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se encontro ningun invoiceDetail con ese ID" ,
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Error.class))})
    })
    @GetMapping("/details/{id}")
    public ResponseEntity<InvoiceDetails> getInvoiceDetailsById(@PathVariable Integer id) throws Exception {
        InvoiceDetails invoiceDetails = invoiceDetailsService.getInvoiceDetailsById(id);
        return ResponseEntity.ok(invoiceDetails);
    }

    @Operation(summary = "Crear invoiceDetail", description = "Nos permite crear un invoiceDetail")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa"),
            @ApiResponse(responseCode = "400", description = "Peticion incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se pudo crear el invoiceDetail" ,
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Error.class))})
    })
    @PostMapping("/details")
    public ResponseEntity<InvoiceDetails> postInvoiceDetails(@RequestBody InvoiceDetails invoiceDetails) throws Exception {
        invoiceDetailsService.createInvoiceDetails(invoiceDetails);
        return ResponseEntity.ok(invoiceDetails);
    }

    @Operation(summary = "Borrar invoiceDetail", description = "Nos permite borrar un invoiceDetail por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa"),
            @ApiResponse(responseCode = "400", description = "Peticion incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se pudo borrar el invoiceDetail" ,
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Error.class))})
    })
    @PostMapping("/details/{id}")
    public void deleteInvoiceDetailsById(@PathVariable Integer id) throws Exception {
        invoiceDetailsService.deleteInvoiceDetailsById(id);
    }


}
