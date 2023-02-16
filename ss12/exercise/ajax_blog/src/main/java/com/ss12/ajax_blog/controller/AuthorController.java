package com.ss12.ajax_blog.controller;

import com.ss12.ajax_blog.model.Author;
import com.ss12.ajax_blog.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private IAuthorService authorService;

    @GetMapping()
    public ResponseEntity<List<Author>> listAll(){
        List<Author> authors = authorService.findAll();
        if(authors.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @PostMapping("/save_author")
    public ResponseEntity save(@RequestBody Author author){
        authorService.save(author);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
