package com.willca.product.service;

import Interceptor.ServiceLogged;
import com.willca.product.dto.LoginRequest;
import com.willca.product.dto.TokenResponse;
import com.willca.product.entity.User;
import com.willca.product.repository.UserRepository;
import io.quarkus.security.UnauthorizedException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.jbosslog.JBossLog;

@JBossLog
@ApplicationScoped
public class AuthService {

    @Inject
    UserRepository userRepository;

    @Inject
    PasswordService passwordService;

    @Inject
    TokenService tokenService;

    public TokenResponse login(LoginRequest request) {

        User user = userRepository.findByUsername(request.getUsername());
        log.infof("User=%s Roles=%s", user.getUsername(), user.getRoles());

        if (user == null || !passwordService.matches(request.getPassword(), user.getPassword())) {
            throw new UnauthorizedException("Invalid username or password");
        }

        String token = tokenService.generateToken(
                user.getId().toString(),
                user.getUsername(),
                user.getRoles()
        );

        return new TokenResponse(token, "Bearer");
    }
}
