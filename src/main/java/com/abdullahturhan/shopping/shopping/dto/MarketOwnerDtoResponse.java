package com.abdullahturhan.shopping.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public final class MarketOwnerDtoResponse {
    private String fullName;
    private String marketName;
    private String email;
}
