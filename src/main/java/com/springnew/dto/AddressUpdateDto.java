package com.springnew.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressUpdateDto {
    private String city;
    private String state;
    private String zipcode;
}
