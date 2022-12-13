package com.example.catalogservice.service;

import com.example.catalogservice.dto.AddProductDto;
import com.example.catalogservice.exception.ProductDoesNotExistException;
import com.example.catalogservice.model.Product;
import com.example.catalogservice.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(AddProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return this.productRepository.save(product);
    }

    public Product getProductById(Long productId) {
        Product product = this.productRepository
                .findById(productId)
                .orElseThrow(() ->
                        new ProductDoesNotExistException("Product with that id does not exist in inventory.")
                );
        return product;
    }
    public Product getProductBySku(String sku) {
        Product product = this.productRepository
                .findBySku(sku)
                .orElseThrow(
                        () -> new ProductDoesNotExistException("No product with the provided SKU.")
                );
        return product;
    }

}
