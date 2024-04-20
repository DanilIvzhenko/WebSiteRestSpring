package com.proj.website.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;

@Data
public class ProductRequest {
    @NotBlank
    private String name;
    @NonNull
    private Integer price;
    @NonNull
    private Integer categoryId;
}
