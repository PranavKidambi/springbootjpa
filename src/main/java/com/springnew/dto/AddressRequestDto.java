package com.springnew.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressRequestDto{
    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    private String zipcode;
}
