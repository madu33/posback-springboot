package com.pos.service.impl;

import com.pos.dto.ProductDto;
import com.pos.entity.Product;
import com.pos.repo.ProductRepo;
import com.pos.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<ProductDto> addProduct(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        productRepo.save(product);
        return null;
    }

    @Override
    public ResponseEntity<ProductDto> deleteProduct(Integer productId) {
        productRepo.deleteById(productId);
        return null;
    }

    @Override
    public ResponseEntity<ProductDto> updateProduct(ProductDto productDto) {
        Product product=modelMapper.map(productDto,Product.class);
        productRepo.save(product);
        return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDto> searchProduct(String productName) {
        Product product = productRepo.searchProduct(productName);
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return new ResponseEntity<ProductDto>(productDto,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductDto>> getAllProduct() {
        List<Product> all = productRepo.findAll();
        return null;
    }
}
