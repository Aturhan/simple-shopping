package com.abdullahturhan.shopping.shopping.dto;

import com.abdullahturhan.shopping.shopping.enumType.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public final class FindProductResponse {
    private Long id;
    private String name;
    private Integer amount;
    private Double price;
    private Category category;
    private Long ownerId;
}
