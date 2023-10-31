package com.sravs.ecommerce.dto;

import jakarta.validation.constraints.NotNull;

public class ProductDto {
    //for create it can be optinal
    //For update we need the Id
    private Integer id;
    private @NotNull String name;
    private @NotNull String imageUrl;
    private @NotNull String description;
    private @NotNull String price;
    private @NotNull Integer categoryId;

    public ProductDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
