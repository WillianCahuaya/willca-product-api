package com.willca.product.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class WeatherExceptionResponseMapper implements ExceptionMapper<WeatherException> {

    @Override
    public Response toResponse(WeatherException exception) {

        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(exception.getMessage())
                .build();
    }
}
