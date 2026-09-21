package com.willca.product.service;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.time.Duration;
import java.util.Set;

@ApplicationScoped
public class TokenService {

    @ConfigProperty(name = "product.jwt.issuer")
    String issuer;

    @ConfigProperty(name = "product.jwt.audience")
    String audience;

    @ConfigProperty(name = "product.jwt.expiration")
    long expiration;

    public String generateToken(String userId, String username, Set<String> roles) {
        return Jwt
                .issuer(issuer)
                .audience(audience)
                .subject(userId)
                .upn(username)
                .groups(roles)
                .expiresIn(Duration.ofSeconds(expiration))
                .sign();
    }
}
