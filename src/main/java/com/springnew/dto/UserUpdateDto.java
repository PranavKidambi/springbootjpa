package com.springnew.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserUpdateDto {
    private String name;
    private String email;
    private LocalDate birthday;
    private String phone;
    private boolean active;
    private Double salary;
    private AddressUpdateDto address;
}
