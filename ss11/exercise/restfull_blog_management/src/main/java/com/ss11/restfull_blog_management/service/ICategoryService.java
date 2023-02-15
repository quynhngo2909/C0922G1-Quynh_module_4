package com.ss11.restfull_blog_management.service;


import com.ss11.restfull_blog_management.model.Category;

public interface ICategoryService extends  IGeneralService<Category> {
    Category findByNameContaining (String name);
}
