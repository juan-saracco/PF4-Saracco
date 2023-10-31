package com.proyecto.demo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;


@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id autogenerado", requiredMode = Schema.RequiredMode.AUTO, example = "1")
    private Integer id;
    @Schema(description = "Nombre del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Juan")
    private String name;
    @Schema(description = "Apelido del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Perez")
    @Column(name = "last_name")
    private String lastName;
    @Schema(description = "Numero de documento", requiredMode = Schema.RequiredMode.REQUIRED, example = "12345678")
    @Column(name = "doc_number")
    private String docNumber;

    public Client(){
    }

    public Client(Integer id, String name, String lastName, String docNumber) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.docNumber = docNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }
}
