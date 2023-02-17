package com.ss12.ajax_blog.controller;

import com.ss12.ajax_blog.model.Blog;
import com.ss12.ajax_blog.model.BlogDto;
import com.ss12.ajax_blog.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping("")
    public ResponseEntity<List<Blog>> listAll(){
        List<Blog> blogs = blogService.findAll();
        if(blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @PostMapping("/save_blog")
    public ResponseEntity save(@RequestBody BlogDto blogDto){
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto, blog);
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> searchByName(@RequestParam(name = "name") String name){
        List<Blog> blogs = blogService.searchBlogsByNameContaining(name);
        if(blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
