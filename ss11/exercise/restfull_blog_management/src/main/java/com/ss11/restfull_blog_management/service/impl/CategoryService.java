package com.ss11.restfull_blog_management.service.impl;


import com.ss11.restfull_blog_management.model.Category;
import com.ss11.restfull_blog_management.respository.ICategoryRepository;
import com.ss11.restfull_blog_management.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(String id) {
       return categoryRepository.findById(id).get();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void remove(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public Category findByNameContaining(String name) {
        return categoryRepository.findByNameContaining(name);
    }
}
