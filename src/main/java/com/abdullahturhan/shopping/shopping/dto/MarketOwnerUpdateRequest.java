package com.abdullahturhan.shopping.shopping.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public final class MarketOwnerUpdateRequest {
    @NotBlank
    private String fullName;
    @Email
    @NotBlank
    private String marketName;
    @NotBlank
    private String email;
    @NotBlank
    private String address;
}
