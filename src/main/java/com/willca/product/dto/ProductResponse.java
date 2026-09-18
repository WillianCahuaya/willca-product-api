package com.willca.product.dto;

import lombok.Data;

@Data
public class ProductResponse {

    private String id;
    private String name;
    private Double price;
    private String status;
}
