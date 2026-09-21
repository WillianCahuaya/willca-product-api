package com.willca.product.service;

import Interceptor.ServiceLogged;
import com.willca.product.client.WeatherClient;
import com.willca.product.dto.WeatherResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.jbosslog.JBossLog;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@JBossLog
@ServiceLogged
@ApplicationScoped
public class WeatherService {

    @Inject
    @RestClient
    WeatherClient weatherClient;

    public WeatherResponse getWeather(String city) {
        var external = weatherClient.getWeather(city);

        return new WeatherResponse(
                external.getName(),
                external.getMain().getTemp(),
                external.getMain().getHumidity(),
                external.getWeather().get(0).getDescription()
        );
    }

}
