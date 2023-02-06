package com.ss05.service;

import java.util.List;

public interface IGeneralService<T>{
    List<T> findAll();

    boolean save(T t);
    void update(Long id, T t);
    void delete(Long id);
    T findById(Long id);
    List<T> findByName(String name);
}
