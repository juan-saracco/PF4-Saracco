package com.proyecto.demo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id autogenerado", requiredMode = Schema.RequiredMode.AUTO, example = "1")
    private Integer id;

    @Schema(description = "Cliente que compro un producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "Juan Perez")
    @ManyToOne
    private Client client;

    @Column(name = "created_at")
    @Schema(description = "Fecha en el que se compro el producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "07/26/2002")
    private Date createdAt;

    @Schema(description = "Precio total a pagar", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    private Double total;

    public Invoice( ) {
    }

    public Invoice(Integer id, Client client, Date createdAt, Double total) {
        this.id = id;
        this.client = client;
        this.createdAt = createdAt;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

}
