package com.ss06.personal_blog.service;

import com.ss06.personal_blog.model.Blog;
import com.ss06.personal_blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IBlogService extends  IGeneralService<Blog>{
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findByNameContaining(String name, Pageable pageable);
    Page<Blog> findByCategory(Category category, Pageable pageable);
}
