package com.willca.product.exception;

import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

@Provider
public class WeatherExceptionMapper implements ResponseExceptionMapper<WeatherException> {

    @Override
    public WeatherException toThrowable(Response response) {

        return switch (response.getStatus()) {
            case 401 -> new WeatherException("OpenWeather API Key inválida");
            case 404 -> new WeatherException("Ciudad no encontrada");
            case 429 -> new WeatherException("OpenWeather: límite de requests excedido");
            default -> {
                if (response.getStatus() >= 500) {
                    yield new WeatherException("OpenWeather no disponible");
                }
                yield new WeatherException("Error OpenWeather: " + response.getStatus());
            }
        };
    }

    @Override
    public boolean handles(int status, MultivaluedMap<String, Object> headers) {
        return status >= 400;
    }
}