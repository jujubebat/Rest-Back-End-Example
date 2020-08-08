package com.jujubebat.controller;

import com.jujubebat.dto.Category;
import com.jujubebat.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/categories")
public class CategoriesApiController {

    private final CategoryService categoryService;

    @Autowired
    public CategoriesApiController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getPersonName(){
        return categoryService.getCategories();
    }
}
