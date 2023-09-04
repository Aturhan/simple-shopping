package com.abdullahturhan.shopping.shopping.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class UpdateProductRequest {
    @NotBlank
    private Double price;
    @NotBlank
    private Integer amount;
}

