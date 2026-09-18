package com.willca.product.dto;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductRequest {

    @NotBlank
    private String name;

    @NotNull
    @Positive
    private Double price;

    @NotBlank
    private String status;
}
