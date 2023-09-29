package com.proyecto.demo.service;

import com.proyecto.demo.entity.Product;
import com.proyecto.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void createProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProductById(Integer id) throws Exception {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()){
            return product.get();
        }else{
            throw new Exception("Producto no encontrado");
        }
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public void deleteProduct(Integer id) throws Exception {
        Product product = getProductById(id);
        productRepository.delete(product);
    }
}
