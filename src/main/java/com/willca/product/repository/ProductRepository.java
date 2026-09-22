package com.willca.product.repository;

import com.willca.product.entity.Product;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ProductRepository implements PanacheMongoRepository<Product> {

    public List<Product> findByStatus(String status) {
        return find("status", status).list();
    }
}