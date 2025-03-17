package com.fpoly.service;

import com.fpoly.model.Product;
import com.fpoly.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    // Tiêm repository qua constructor
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    
    public Product getProductById(int id) {
        Optional<Product> optional = productRepository.findById(id);
        return optional.orElse(null);
    }
    
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
    
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
