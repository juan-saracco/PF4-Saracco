package com.proyecto.demo.service;

import com.proyecto.demo.entity.Product;
import com.proyecto.demo.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Product createProduct(Product product) throws Exception {
        validate(product.getDescription(), product.getStock(), product.getPrice());
        productRepository.save(product);
        return product;
    }

    public Product getProductById(Integer id) throws Exception {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()){
            return product.get();
        }else{
            throw new Exception("Product not found");
        }
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @Transactional
    public Product modifyProduct(Integer id, Product product) throws Exception {
        Product modifiedProduct = getProductById(id);

        modifiedProduct.setDescription(product.getDescription());
        modifiedProduct.setCode(product.getCode());
        modifiedProduct.setStock(product.getStock());
        modifiedProduct.setPrice(product.getPrice());

        productRepository.save(modifiedProduct);
        return modifiedProduct;
    }

    @Transactional
    public void deleteProduct(Integer id) throws Exception {
        Product product = getProductById(id);
        productRepository.delete(product);
    }

    public void validate(String description, Integer stock, Double price) throws Exception {

        if (description.isBlank()){
            throw new Exception("Please fill the description");
        } else if (description.length() < 5) {
            throw new Exception("Description is too short");
        }else if (description.length() > 150){
            throw new Exception("Description is too long");
        }

    }
}
