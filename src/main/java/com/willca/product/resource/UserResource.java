package com.willca.product.resource;

import Interceptor.ResourceLogged;
import com.willca.product.dto.UserBatchRequest;
import com.willca.product.service.UserService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.List;

@ResourceLogged
@Path("/users")
public class UserResource {

    @Inject
    UserService userService;

    @POST
    @Path("/batch")
    public void createBatch(@Valid List<UserBatchRequest> requests) {
        userService.createBatch(requests);
    }
}
