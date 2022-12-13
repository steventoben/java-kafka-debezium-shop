package com.example.catalogservice.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;

//@Data
//@Entity
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sku;
    private String name;
    private BigDecimal basePrice;
    private List<Product> variants;

    private String category;

    private List<String> tags;
    private List<String> internalTags; //extended set of tags/topics for better searching
    //private Attribute<String, List<String>> attribute;
}
