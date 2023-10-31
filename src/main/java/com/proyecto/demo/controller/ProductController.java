package com.proyecto.demo.controller;

import com.proyecto.demo.entity.Product;
import com.proyecto.demo.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "Obtener productos", description = "Nos permite obtener la lista de productos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa"),
            @ApiResponse(responseCode = "400", description = "Peticion incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se encontro ningun producto" ,
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Error.class))})
    })
    @GetMapping(value = "/product")
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }

    @Operation(summary = "Obtener un producto", description = "Nos permite obtener un producto por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa"),
            @ApiResponse(responseCode = "400", description = "Peticion incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se encontro ningun producto con ese ID" ,
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Error.class))})
    })
    @GetMapping(value = "/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) throws Exception {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @Operation(summary = "Crear producto", description = "Nos permite crear un producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa"),
            @ApiResponse(responseCode = "400", description = "Peticion incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se pudo crear el producto" ,
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Error.class))})
    })
    @PostMapping(value = "/product")
    public ResponseEntity<Product> postProduct(@RequestBody Product product) throws Exception {
        productService.createProduct(product);
        return ResponseEntity.ok(product);
    }

    @Operation(summary = "Modificar producto", description = "Nos permite modificar un producto por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa"),
            @ApiResponse(responseCode = "400", description = "Peticion incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se encontro ningun prodcuto con ese iD" ,
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Error.class))})
    })
    @PutMapping(value = "/product/modify/{id}")
    public ResponseEntity<Product> modifyProduct(@RequestParam Integer id, @RequestBody Product product) throws Exception {
        productService.modifyProduct(id, product);
        return ResponseEntity.ok(product);
    }

    @Operation(summary = "Borrar producto", description = "Nos permite obtener la lista de clientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa"),
            @ApiResponse(responseCode = "400", description = "Peticion incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se encontro ningun cliente" ,
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Error.class))})
    })
    @PostMapping(value = "/product/{id}")
    public void deleteProduct(@PathVariable Integer id) throws Exception {
        productService.deleteProduct(id);
    }


}
