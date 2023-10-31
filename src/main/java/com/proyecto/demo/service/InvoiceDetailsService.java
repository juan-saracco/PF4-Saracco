package com.proyecto.demo.service;

import com.proyecto.demo.entity.Invoice;
import com.proyecto.demo.entity.InvoiceDetails;
import com.proyecto.demo.entity.Product;
import com.proyecto.demo.repository.InvoiceDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceDetailsService {

    @Autowired
    private InvoiceDetailsRepository invoiceDetailsRepository;

    public void createInvoiceDetails(InvoiceDetails invoiceDetails) throws Exception {
        validate(invoiceDetails.getInvoice(), invoiceDetails.getAmount(), invoiceDetails.getProduct(), invoiceDetails.getPrice());
        invoiceDetails.getProduct().setStock(invoiceDetails.getProduct().getStock()-1);
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

    private void validate(Invoice invoice, Integer amount, Product product, Double price) throws Exception {
        if(invoice == null){
            throw new Exception("Invoice cannot be null");
        }

        if(amount > product.getStock()){
            throw new Exception("There is not enough stock");
        }

        if (product == null){
            throw new Exception("Product cannot be null");
        }

        if (price > 0 ){
            throw new Exception("Price cannot be less/equal than 0");
        }


    }
}
