package com.willca.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherResponse {

    private String city;
    private Double temperature;
    private Integer humidity;
    private String description;
}
