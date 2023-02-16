package com.ss12.ajax_blog.repository;

import com.ss12.ajax_blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, String> {
    List<Blog> searchBlogsByNameContaining(String blogName);
}
