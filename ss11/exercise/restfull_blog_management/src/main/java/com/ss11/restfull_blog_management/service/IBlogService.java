package com.ss11.restfull_blog_management.service;

import com.ss11.restfull_blog_management.model.Blog;
import com.ss11.restfull_blog_management.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IBlogService extends IGeneralService<Blog>{
    List<Blog> search(String categoryID);
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findByNameContaining(String name, Pageable pageable);
    Page<Blog> findByCategory(Category category, Pageable pageable);
}
