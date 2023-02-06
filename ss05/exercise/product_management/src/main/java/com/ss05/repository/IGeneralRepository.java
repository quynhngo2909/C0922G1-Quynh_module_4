package com.ss05.repository;

import java.util.List;

public interface IGeneralRepository<T> {
    List<T> findAll();
    boolean save(T t);
    void update(Long id, T t);
    void delete(Long id);
    T findById(Long id);
    List<T> findByName(String name);
}
