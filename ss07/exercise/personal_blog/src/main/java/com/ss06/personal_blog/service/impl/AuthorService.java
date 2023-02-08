package com.ss06.personal_blog.service.impl;

import com.ss06.personal_blog.model.Author;
import com.ss06.personal_blog.repository.IAuthorRepository;
import com.ss06.personal_blog.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AuthorService implements IAuthorService {
    @Autowired
    private IAuthorRepository authorRepository;
    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(String id) {
        return authorRepository.findById(id);
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
