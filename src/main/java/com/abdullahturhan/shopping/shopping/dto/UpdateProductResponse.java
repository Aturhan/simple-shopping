package com.abdullahturhan.shopping.shopping.dto;

import com.abdullahturhan.shopping.shopping.enumType.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateProductResponse {
    private String name;
    private Integer amount;
    private Double price;
    private Category category;
}

