package com.springnew.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressResponseDto {
    private int id;
    private String city;
    private String state;
    private String zipcode;
}
