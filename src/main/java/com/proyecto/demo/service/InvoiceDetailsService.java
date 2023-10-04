package com.proyecto.demo.service;

import com.proyecto.demo.entity.InvoiceDetails;
import com.proyecto.demo.repository.InvoiceDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceDetailsService {

    @Autowired
    private InvoiceDetailsRepository invoiceDetailsRepository;

    public void createInvoiceDetails(InvoiceDetails invoiceDetails){
        invoiceDetailsRepository.save(invoiceDetails);
    }

    public List<InvoiceDetails> getInvoicesDetails(){
        return invoiceDetailsRepository.findAll();
    }

    public InvoiceDetails getInvoiceDetailsById(Integer id) throws Exception {
        Optional<InvoiceDetails> invoiceDetails = invoiceDetailsRepository.findById(id);

        if (invoiceDetails.isPresent()){
            return invoiceDetails.get();
        }else {
            throw new Exception("Invoice details not found");
        }
    }

    public void deleteInvoiceDetailsById(Integer id) throws Exception {
        InvoiceDetails invoiceDetails = getInvoiceDetailsById(id);

        invoiceDetailsRepository.delete(invoiceDetails);
    }
}
