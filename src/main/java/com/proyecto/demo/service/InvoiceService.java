package com.proyecto.demo.service;

import com.proyecto.demo.entity.Client;
import com.proyecto.demo.entity.Invoice;
import com.proyecto.demo.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public void createInvoice(Invoice invoice) throws Exception {
        validate(invoice.getClient(), invoice.getTotal());
        invoiceRepository.save(invoice);
    }

    public List<Invoice> getInvoices(){
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(Integer id) throws Exception {
        Optional<Invoice> invoice = invoiceRepository.findById(id);

        if (invoice.isPresent()){
            return invoice.get();
        }else{
            throw new Exception("Invoice not found");
        }
    }

    public void deleteInvoiceById(Integer id) throws Exception {
        Invoice invoice = getInvoiceById(id);

        invoiceRepository.delete(invoice);
    }

    private void validate(Client client, Double total) throws Exception {
        if (client == null){
            throw new Exception("Client cannot be null");
        }

        if (total <= 0){
            throw new Exception("Total cannot be less than 0");
        }
    }
}
