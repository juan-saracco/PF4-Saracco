package com.proyecto.demo.controller;

import com.proyecto.demo.entity.Invoice;
import com.proyecto.demo.service.InvoiceService;
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

    @GetMapping("/invoice")
    public ResponseEntity<List<Invoice>> getInvoices(){
        List<Invoice> invoices = invoiceService.getInvoices();
        return ResponseEntity.ok(invoices);
    }

    @GetMapping("/invoice/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Integer id) throws Exception {
        Invoice invoice = invoiceService.getInvoiceById(id);
        return ResponseEntity.ok(invoice);
    }

    @PostMapping("/invoice")
    public ResponseEntity<Invoice> postInvoice(@RequestBody Invoice invoice){
        invoiceService.createInvoice(invoice);
        return ResponseEntity.ok(invoice);
    }

    @PostMapping("/invoice/{id}")
    public void deleteInvoiceById(@PathVariable Integer id) throws Exception {
        invoiceService.deleteInvoiceById(id);
    }
}
