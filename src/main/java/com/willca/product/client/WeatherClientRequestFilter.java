package com.willca.product.client;

import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.io.IOException;
import java.net.URI;

@Provider
public class WeatherClientRequestFilter implements ClientRequestFilter {

    @ConfigProperty(name = "weather.api-key")
    String apiKey;

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {

        requestContext.getHeaders()
                .add("X-Client", "product-api");

        URI uri = requestContext.getUri();

        String separator = uri.getQuery() == null ? "?" : "&";

        URI newUri = URI.create(uri + separator + "appid=" + apiKey);

        requestContext.setUri(newUri);
    }
}
