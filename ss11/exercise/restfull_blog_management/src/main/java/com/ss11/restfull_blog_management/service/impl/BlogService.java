package com.ss11.restfull_blog_management.service.impl;


import com.ss11.restfull_blog_management.model.Blog;
import com.ss11.restfull_blog_management.model.Category;
import com.ss11.restfull_blog_management.respository.IBlogRepository;
import com.ss11.restfull_blog_management.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> search(String categoryID) {
       return blogRepository.search(categoryID);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findByNameContaining(String name, Pageable pageable) {
        return blogRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Page<Blog> findByCategory(Category category, Pageable pageable) {
        return blogRepository.findByCategory(category, pageable);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(String id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Blog blog) {
        blogRepository.delete(blog);
    }
}



