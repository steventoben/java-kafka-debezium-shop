package com.example.catalogservice.controller;

import com.example.catalogservice.dto.AddProductDto;
import com.example.catalogservice.model.Product;
import com.example.catalogservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("catalog")
public class CatalogController {

    private final ProductService productService;

    public CatalogController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> addProductToCatalog(@RequestBody AddProductDto productDto) {
        Product product = this.productService.addProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("product")
    public ResponseEntity<Product> getProductById(@RequestParam("id") Long id) {
        Product product = this.productService.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
    @GetMapping("product/{sku}")
    public ResponseEntity<Product> getProductBySku(@PathVariable String sku) {
        Product product = this.productService.getProductBySku(sku);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

}
