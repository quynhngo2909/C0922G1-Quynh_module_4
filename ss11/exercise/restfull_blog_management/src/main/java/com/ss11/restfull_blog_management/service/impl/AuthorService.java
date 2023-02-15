package com.ss11.restfull_blog_management.service.impl;

import com.ss11.restfull_blog_management.model.Author;
import com.ss11.restfull_blog_management.respository.IAuthorRepository;
import com.ss11.restfull_blog_management.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements IAuthorService {
    @Autowired
    private IAuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(String id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void remove(Author author) {
        authorRepository.delete(author);
    }
}
