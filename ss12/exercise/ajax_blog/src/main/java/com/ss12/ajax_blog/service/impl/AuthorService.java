package com.ss12.ajax_blog.service.impl;

import com.ss12.ajax_blog.model.Author;
import com.ss12.ajax_blog.repository.IAuthorRepository;
import com.ss12.ajax_blog.service.IAuthorService;
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
    public void save(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void delete(Author author) {
        authorRepository.delete(author);
    }

    @Override
    public Author findById(String id) {
        return authorRepository.findById(id).get();
    }
}
