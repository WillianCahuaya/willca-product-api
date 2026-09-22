package com.willca.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Set;

@Data
public class UserBatchRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotEmpty
    private Set<String> roles;
}
