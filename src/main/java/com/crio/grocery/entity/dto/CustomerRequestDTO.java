package com.crio.grocery.entity.dto;

import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data
public class CustomerRequestDTO {
    @NotBlank(message = "Name is required")
    private String name;

    private String address;

    @NotBlank(message = "Phone is required")
    private String phone;

    @Email(message = "Email should be valid")
    private String email;
}
