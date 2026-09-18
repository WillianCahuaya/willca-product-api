package com.willca.product.service;

import com.willca.product.dto.ProductRequest;
import com.willca.product.dto.ProductResponse;
import com.willca.product.exception.ProductNotFoundException;
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

    public List<ProductResponse> findAll() {
        return productRepository.listAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public List<ProductResponse> findByStatus(String status) {
        return productRepository.findByStatus(status)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public ProductResponse findById(ObjectId id) {
        Product product = productRepository.findById(id);
        if (product == null) {
            throw new ProductNotFoundException("Product not found: " + id);
        }
        return toResponse(product);
    }

    public ProductResponse create(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStatus(request.getStatus());
        productRepository.persist(product);
        return toResponse(product);
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

        return toResponse(existing);
    }

    public boolean delete(ObjectId id) {
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