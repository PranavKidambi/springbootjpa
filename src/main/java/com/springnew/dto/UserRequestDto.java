package com.springnew.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDto {
    @NotBlank
    private String name;

    @Email(message = "invalid")
    @Pattern(regexp = ".*@gmail\\.com$", message = "should contain @gmail.com")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "must have 10 digits")
    private String phone;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate birthday;

    private boolean active;

    @DecimalMin(value = "0.0", inclusive = false , message = "invalid")
    private Double salary;

    private AddressRequestDto address;
}
