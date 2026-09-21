package com.willca.product.dto.external;

import lombok.Data;

import java.util.List;

@Data
public class WeatherResponse {

    private String name;
    private Main main;
    private List<Weather> weather;

    @Data
    public static class Main {
        private Double temp;
        private Integer humidity;
    }

    @Data
    public static class Weather {
        private String description;
    }
}

