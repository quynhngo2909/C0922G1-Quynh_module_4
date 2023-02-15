package com.ss11.restfull_blog_management.controller;

import com.ss11.restfull_blog_management.model.Author;
import com.ss11.restfull_blog_management.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
    @Autowired
    private IAuthorService authorService;

    @GetMapping("")
    private ResponseEntity<List<Author>> findAll(){
        List<Author> authors = authorService.findAll();
        if(authors.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @PostMapping("/save_author")
    public ResponseEntity save(@RequestBody Author author){
        authorService.save(author);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
