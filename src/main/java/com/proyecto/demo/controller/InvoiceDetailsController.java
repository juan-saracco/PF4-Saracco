package com.proyecto.demo.controller;

import com.proyecto.demo.entity.InvoiceDetails;
import com.proyecto.demo.service.InvoiceDetailsService;
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

    @GetMapping("/details")
    public ResponseEntity<List<InvoiceDetails>> getInvoicesDetails(){
        List<InvoiceDetails> invoicesDetails = invoiceDetailsService.getInvoicesDetails();
        return ResponseEntity.ok(invoicesDetails);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<InvoiceDetails> getInvoiceDetailsById(@PathVariable Integer id) throws Exception {
        InvoiceDetails invoiceDetails = invoiceDetailsService.getInvoiceDetailsById(id);
        return ResponseEntity.ok(invoiceDetails);
    }

    @PostMapping("/details")
    public ResponseEntity<InvoiceDetails> postInvoiceDetails(@RequestBody InvoiceDetails invoiceDetails){
        invoiceDetailsService.createInvoiceDetails(invoiceDetails);
        return ResponseEntity.ok(invoiceDetails);
    }

    @PostMapping("/details/{id}")
    public void deleteInvoiceDetailsById(@PathVariable Integer id) throws Exception {
        invoiceDetailsService.deleteInvoiceDetailsById(id);
    }


}
