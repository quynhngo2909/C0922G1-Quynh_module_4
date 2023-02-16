package com.ss12.ajax_blog.service.impl;

import com.ss12.ajax_blog.model.Category;
import com.ss12.ajax_blog.repository.ICategoryRepository;
import com.ss12.ajax_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public Category findById(String id) {
        return categoryRepository.findById(id).get();
    }
}
