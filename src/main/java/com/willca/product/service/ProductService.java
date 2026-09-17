package com.willca.product.service;

import com.willca.product.model.Product;
import com.willca.product.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.bson.types.ObjectId;

import java.util.List;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.listAll();
    }

    public List<Product> findByStatus(String status) {
        return productRepository.findByStatus(status);
    }

    public Product findById(ObjectId id) {
        return productRepository.findById(id);
    }

    public Product create(Product product) {
        productRepository.persist(product);
        return product;
    }

    public Product update(ObjectId id, Product product) {
        Product existing = productRepository.findById(id);

        if (existing == null) {
            return null;
        }

        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        existing.setStatus(product.getStatus());
        productRepository.update(existing);

        return existing;
    }

    public boolean delete(ObjectId id) {
        return productRepository.deleteById(id);
    }
}