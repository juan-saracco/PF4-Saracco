package com.proyecto.demo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id autogenerado", requiredMode = Schema.RequiredMode.AUTO, example = "1")
    private Integer id;
    @Schema(description = "Descripcion del producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "Bolsa de boxeo")
    private String description;

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Schema(description = "Codigo del producto (autogenerado)", requiredMode = Schema.RequiredMode.REQUIRED, example = "123e4567-e89b-12d3-a456-426614174000")
    private String code;
    @Schema(description = "Cantidad de stock del producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer stock;
    @Schema(description = "Precio del producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "200.00")
    private Double price;

    public Product() {
    }

    public Product(Integer id, String description, String code, Integer stock, Double price) {
        this.id = id;
        this.description = description;
        this.code = code;
        this.stock = stock;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
