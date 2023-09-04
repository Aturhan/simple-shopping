package com.abdullahturhan.shopping.shopping.dto;

import com.abdullahturhan.shopping.shopping.entity.Product;
import com.abdullahturhan.shopping.shopping.enumType.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class ShoppingCartResponse {
    private Long id;
    private Integer amountItem;
    private Double totalPrice;
    private String userFullName;
    private String userEmail;
    private String userAddress;
    private Long productId;
    private String productName;
    private Double price;
    private Category category;
}

