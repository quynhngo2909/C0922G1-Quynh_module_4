package com.ss12.ajax_blog.service;

import com.ss12.ajax_blog.model.Blog;

import java.util.List;

public interface IBlogService extends IGeneralService<Blog>{
    List<Blog> searchBlogsByNameContaining(String blogName);
}
