package com.example.catalogservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddProductDto {
    private String sku;
    private String name;
    private BigDecimal price;
    private Integer stock;
}
