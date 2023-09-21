package com.proyecto.demo.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "invoice_details")
public class invoiceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @OneToOne
    @Column(name = "invoice_id")
    private Invoice invoice;

    private Integer amount;
    @ManyToOne
    @Column(name = "product_id")
    private Product product;
    private Double price;

    public invoiceDetails( ) {
    }

    public invoiceDetails(Integer id, Invoice invoice, Integer amount, Product product, Double price) {
        this.id = id;
        this.invoice = invoice;
        this.amount = amount;
        this.product = product;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
