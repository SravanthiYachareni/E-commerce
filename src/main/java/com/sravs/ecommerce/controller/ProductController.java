package com.sravs.ecommerce.controller;

import com.sravs.ecommerce.common.ApiResponse;
import com.sravs.ecommerce.dto.ProductDto;
import com.sravs.ecommerce.model.Category;
import com.sravs.ecommerce.repository.CategoryRepo;
import com.sravs.ecommerce.service.ProductService;


import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


// GET https://localhost:8080/product/add
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryRepo categoryRepo;

    @PostMapping("/add")

    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productDto) {
        Optional<Category> optionalCategory = categoryRepo.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<>(new ApiResponse(false,"category does not exists"), HttpStatusCode.valueOf(HttpStatus.SC_BAD_REQUEST));

        }
        productService.createProduct(productDto,optionalCategory.get());
        return new ResponseEntity<>(new  ApiResponse(true,"product has been added"), HttpStatusCode.valueOf(HttpStatus.SC_CREATED));
    }
    @GetMapping("/")
    public ResponseEntity<List<ProductDto>>getProducts(){
        List<ProductDto> products=  productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatusCode.valueOf(HttpStatus.SC_OK));
    }
    @PostMapping("/update/{productId}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productId")Integer productId,@RequestBody ProductDto productDto) throws Exception {
        Optional<Category> optionalCategory = categoryRepo.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<>(new ApiResponse(false,"category does not exists"), HttpStatusCode.valueOf(HttpStatus.SC_BAD_REQUEST));

        }
        productService.updateProduct(productDto,productId);
        return new ResponseEntity<>(new  ApiResponse(true,"product has been updated"), HttpStatusCode.valueOf(HttpStatus.SC_CREATED));
    }
}
