package com.crio.grocery.entity.dto;

import lombok.Data;

@Data
public class ItemResponseDTO {
    private Integer id;
    private String name;
    private String category;
    private Double price;
    private Integer quantity;
}
