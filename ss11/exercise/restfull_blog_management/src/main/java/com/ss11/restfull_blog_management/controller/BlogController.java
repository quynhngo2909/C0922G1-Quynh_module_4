package com.ss11.restfull_blog_management.controller;

import com.ss11.restfull_blog_management.model.Blog;
import com.ss11.restfull_blog_management.model.Category;
import com.ss11.restfull_blog_management.service.IBlogService;
import com.ss11.restfull_blog_management.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<Page<Blog>> findAll(@PageableDefault(size = 2, page = 0) Pageable pageable){
        Page<Blog> blogs = blogService.findAll(pageable);
        if(blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @PostMapping("/save_blog")
    private ResponseEntity save(@RequestBody Blog blog){
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Blog> findById(@PathVariable String id){
        Blog blog = blogService.findById(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Blog>> findByCategory(@RequestParam String category){
        Category category1 = categoryService.findByNameContaining(category);
        List<Blog> blogs = blogService.search(category1.getId());
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
