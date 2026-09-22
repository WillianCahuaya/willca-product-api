package com.willca.product.resource;

import com.willca.product.dto.LoginRequest;
import com.willca.product.dto.TokenResponse;
import com.willca.product.service.AuthService;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/auth")
public class AuthResource {

    @Inject
    AuthService authService;

    @Inject
    SecurityIdentity securityIdentity;

    @POST
    @Path("/login")
    public TokenResponse login(@Valid LoginRequest request) {
        return authService.login(request);
    }

    @GET
    @Path("/security-test")
    public String securityTest() {
        return "User=" + securityIdentity.getPrincipal().getName() + " Roles=" + securityIdentity.getRoles();
    }
}