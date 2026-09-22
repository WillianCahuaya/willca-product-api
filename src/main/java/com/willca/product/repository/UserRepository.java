package com.willca.product.repository;

import com.willca.product.entity.User;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheMongoRepository<User> {

    public User findByUsername(String username) {
        return find("username", username).firstResult();
    }
}
