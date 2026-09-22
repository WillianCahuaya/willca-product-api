package com.willca.product.resource;

import Interceptor.ResourceLogged;
import com.willca.product.dto.WeatherResponse;
import com.willca.product.service.WeatherService;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import lombok.extern.jbosslog.JBossLog;

@JBossLog
@ResourceLogged
@Path("/weather")
public class WeatherResource {

    @Inject
    WeatherService weatherService;

    @GET
    @RolesAllowed("ADMIN")
    public WeatherResponse getWeather(@QueryParam("city") String city) {
        return weatherService.getWeather(city);
    }
}
