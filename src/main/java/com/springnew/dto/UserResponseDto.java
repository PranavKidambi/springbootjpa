// test comments
package com.springnew.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {
    private int id;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthday;
    private boolean active;
    private Double salary;
    private AddressResponseDto address;
}
