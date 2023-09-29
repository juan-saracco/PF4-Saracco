package com.proyecto.demo.controller;

import com.proyecto.demo.entity.Product;
import com.proyecto.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) throws Exception {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> postProduct(@RequestBody Product product){
        productService.createProduct(product);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/product/{id}")
    public void deleteProduct(@PathVariable Integer id) throws Exception {
        productService.deleteProduct(id);
    }


}
