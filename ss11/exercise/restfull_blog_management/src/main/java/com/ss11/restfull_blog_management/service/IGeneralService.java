package com.ss11.restfull_blog_management.service;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();
    T findById(String id);
    void save(T t);
    void remove(T t);
}
