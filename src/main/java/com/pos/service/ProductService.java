package com.pos.service;

import com.pos.dto.ProductDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<ProductDto> addProduct(ProductDto productDto);

    ResponseEntity<ProductDto> deleteProduct(Integer productId);

    ResponseEntity<ProductDto> updateProduct(ProductDto productDto);

    ResponseEntity<ProductDto> searchProduct(String productName);

    ResponseEntity<List<ProductDto>> getAllProduct();
}
