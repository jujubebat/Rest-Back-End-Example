package com.jujubebat.service;

import com.jujubebat.dao.CategoryDao;
import com.jujubebat.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryDao categoriesDao;

    @Autowired
    public CategoryService(CategoryDao categoriesDao) {
        this.categoriesDao = categoriesDao;
    }

    public List<Category> getCategories() {
        return categoriesDao.selectAll();
    }
}
