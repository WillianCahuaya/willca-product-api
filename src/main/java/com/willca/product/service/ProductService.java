package com.willca.product.service;

import Interceptor.ServiceLogged;
import com.willca.product.dto.ProductRequest;
import com.willca.product.dto.ProductResponse;
import com.willca.product.exception.ProductNotFoundException;
import com.willca.product.entity.Product;
import com.willca.product.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.jbosslog.JBossLog;
import org.bson.types.ObjectId;

import java.util.List;

@JBossLog
@ServiceLogged
@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    public List<ProductResponse> findAll() {
        List<ProductResponse> result = productRepository.listAll()
                .stream()
                .map(this::toResponse)
                .toList();

        log.infof("All Products: %s", result.size());
        return result;
    }

    public List<ProductResponse> findByStatus(String status) {
        List<ProductResponse> result = productRepository.findByStatus(status)
                .stream()
                .map(this::toResponse)
                .toList();
        log.infof("All Products: %s", result.size());
        return result;
    }

    public ProductResponse findById(ObjectId id) {
        Product product = productRepository.findById(id);
        log.infof("Product found: %s", product);
        if (product == null) {
            throw new ProductNotFoundException("Product not found: " + id);
        }
        ProductResponse response = toResponse(product);
        log.infof("Product converted: %s", response);
        return response;
    }

    public ProductResponse create(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStatus(request.getStatus());
        productRepository.persist(product);
        log.infof("Product created: %s", product);

        ProductResponse response = toResponse(product);
        log.infof("Product converted: %s", response);
        return response;
    }

    public ProductResponse update(ObjectId id, Product product) {
        Product existing = productRepository.findById(id);

        if (existing == null) {
            return null;
        }

        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        existing.setStatus(product.getStatus());
        productRepository.update(existing);
        log.infof("Product updated: %s", product);

        ProductResponse response = toResponse(product);
        log.infof("Product converted: %s", response);
        return response;
    }

    public boolean delete(ObjectId id) {
        log.infof("Product ID to delete: %s", id);
        return productRepository.deleteById(id);
    }

    private ProductResponse toResponse(Product product) {

        ProductResponse response = new ProductResponse();

        response.setId(product.getId().toString());
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        response.setStatus(product.getStatus());

        return response;
    }
}