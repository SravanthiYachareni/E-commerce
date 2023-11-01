package com.sravs.ecommerce.controller;

import com.sravs.ecommerce.model.Category;
import com.sravs.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public String createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return "success";
    }

    @GetMapping("/list")
    public List<Category> listCategory() {
        return categoryService.listCategory();

    }


}
