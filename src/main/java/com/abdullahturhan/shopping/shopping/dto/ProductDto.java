package com.abdullahturhan.shopping.shopping.dto;

import com.abdullahturhan.shopping.shopping.enumType.Category;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public final  class ProductDto {
    @NotBlank
    private String name;
    @NotBlank
    private String description;

    @NotBlank
    private Integer amount;

    @NotBlank
    private Double price;

    @NotBlank
    private Category category;

    @NotBlank
    private Long ownerId;
}
