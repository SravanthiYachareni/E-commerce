package com.sravs.ecommerce.service;

import com.sravs.ecommerce.model.Category;
import com.sravs.ecommerce.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
@Autowired
CategoryRepo categoryRepo;
public void createCategory(Category category) {
    categoryRepo.save(category);
}
}
