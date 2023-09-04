package com.abdullahturhan.shopping.shopping.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class ShoppingCartDto {
    @NotBlank
    private Integer amountItem;
    @NotBlank
    private Long userId;
    @NotBlank
    private Long productId;

}

