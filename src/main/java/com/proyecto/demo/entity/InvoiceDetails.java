package com.proyecto.demo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "invoice_detail")
public class InvoiceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id autogenerado", requiredMode = Schema.RequiredMode.AUTO, example = "1")
    private Integer id;

    @Schema(description = "Invoice correspondiente a este invoiceDetail", requiredMode = Schema.RequiredMode.REQUIRED, example = "Invoice (Entity)")
    @OneToOne
    private Invoice invoice;
    @Schema(description = "Cantidad de productos seleccionados", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer amount;
    @Schema(description = "Producto seleccionado", requiredMode = Schema.RequiredMode.REQUIRED, example = "Bolsa de boxeo (Entity)")
    @ManyToOne
    private Product product;

    @Schema(description = "Precio del producto seleccionado", requiredMode = Schema.RequiredMode.REQUIRED, example = "2000.00")
    private Double price;

    public InvoiceDetails( ) {
    }

    public InvoiceDetails(Integer id, Invoice invoice, Integer amount, Product product, Double price) {
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
