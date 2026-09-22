package com.willca.product.service;

import Interceptor.ServiceLogged;
import com.willca.product.dto.UserBatchRequest;
import com.willca.product.entity.User;
import com.willca.product.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ServiceLogged
@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    @Inject
    PasswordService passwordService;

    public void createBatch(List<UserBatchRequest> requests) {

        for (UserBatchRequest request : requests) {

            if (userRepository.findByUsername(request.getUsername()) != null) {
                continue;
            }

            User user = new User();

            user.setUsername(request.getUsername());

            user.setPassword(passwordService.hash(request.getPassword()));

            user.setRoles(request.getRoles());

            userRepository.persist(user);
        }
    }
}
