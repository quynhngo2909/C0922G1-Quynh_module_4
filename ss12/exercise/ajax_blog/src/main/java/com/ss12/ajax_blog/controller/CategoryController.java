package com.ss12.ajax_blog.controller;

import com.ss12.ajax_blog.model.Category;
import com.ss12.ajax_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<Category>> listAll() {
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/save_category")
    public ResponseEntity save(@RequestBody Category category){
        categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
