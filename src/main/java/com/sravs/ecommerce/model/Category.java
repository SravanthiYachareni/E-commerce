package com.sravs.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
@Column(name = "category_name")
private String categoryName ;
   private String description;
   @Column(name = "image_url")
   private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
