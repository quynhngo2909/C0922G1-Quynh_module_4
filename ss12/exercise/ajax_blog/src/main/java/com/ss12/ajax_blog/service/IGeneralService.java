package com.ss12.ajax_blog.service;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();
    void save(T t);
    void delete(T t);
    T findById(String id);
}
