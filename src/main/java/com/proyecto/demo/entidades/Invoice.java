package com.proyecto.demo.entidades;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Invoice {
    @Id
    private Integer id;

    @ManyToOne
    @Column(name = "client_id")
    private Client client;

    @Column(name = "created_at")
    private Date createdAt;

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
