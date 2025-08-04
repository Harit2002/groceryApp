package com.crio.grocery.entity.dto;

import lombok.Data;

@Data
public class CustomerResponseDTO {
        private Integer id;
        private String name;
        private String address;
        private String phone;
        private String email;

}
