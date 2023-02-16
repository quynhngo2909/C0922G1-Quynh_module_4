package com.ss12.ajax_blog.service.impl;

import com.ss12.ajax_blog.model.Blog;
import com.ss12.ajax_blog.repository.IBlogRepository;
import com.ss12.ajax_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public Blog findById(String id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public List<Blog> searchBlogsByNameContaining(String blogName) {
        return blogRepository.searchBlogsByNameContaining(blogName);
    }
}
