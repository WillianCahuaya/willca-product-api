package com.willca.product.client;

import com.willca.product.dto.external.WeatherResponse;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/data/2.5")
@RegisterRestClient(configKey = "weather-api")
@RegisterProvider(WeatherClientRequestFilter.class)
public interface WeatherClient {

    @GET
    @Path("/weather")
    WeatherResponse getWeather(@QueryParam("q") String city);

}
