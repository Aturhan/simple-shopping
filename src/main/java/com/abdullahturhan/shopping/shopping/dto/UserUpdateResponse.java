package com.abdullahturhan.shopping.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public final class UserUpdateResponse {
    private String fullName;
    private String email;
    private String address;
}

