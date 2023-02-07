package com.ss06.personal_blog.service;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();
    Optional<T> findById(String id);
    void save(T t);
    void remove(T t);
}
