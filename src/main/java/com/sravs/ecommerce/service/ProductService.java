package com.sravs.ecommerce.service;

import com.sravs.ecommerce.dto.ProductDto;
import com.sravs.ecommerce.model.Category;
import com.sravs.ecommerce.model.Product;
import com.sravs.ecommerce.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public void createProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        product.setName(productDto.getName());
        product.setCategory(category);
        product.setPrice(productDto.getPrice());
        productRepo.save(product);

    }

    public ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setDescription(product.getDescription());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setName(product.getName());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setPrice(product.getPrice());
        return productDto;

    }

    public List<ProductDto> getAllProducts() {
        List<Product> allproducts = productRepo.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : allproducts) {
            productDtos.add(getProductDto(product));

        }
        return productDtos;
    }


    public void updateProduct(ProductDto productDto, Integer productId)throws  Exception {
        Optional<Product> optionalProduct= productRepo.findById(productId);
        //Throw an excepyion if product does not exists
        if(  !optionalProduct .isPresent()) {
            throw  new Exception("product is  present");
        }
        Product product = optionalProduct.get();
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        productRepo.save(product);
    }
}
