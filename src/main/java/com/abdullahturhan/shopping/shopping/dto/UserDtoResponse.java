package com.abdullahturhan.shopping.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public final class UserDtoResponse {
    private Long id;
    private String fullName;
    private String email;
    private String address;
}

