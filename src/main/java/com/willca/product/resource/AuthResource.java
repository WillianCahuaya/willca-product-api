package com.willca.product.resource;

import com.willca.product.dto.TokenResponse;
import com.willca.product.service.TokenService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.Set;

@Path("/auth")
public class AuthResource {

    @Inject
    TokenService tokenService;

    @POST
    @Path("/login")
    public TokenResponse login() {
        String token = tokenService.generateToken(
                "12345",
                "willca",
                Set.of("USER")
        );

        return new TokenResponse(
                token,
                "Bearer"
        );
    }
}