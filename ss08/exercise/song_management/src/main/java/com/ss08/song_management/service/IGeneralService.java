package com.ss08.song_management.service;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();
    void save(T t);
    T findById(int id);
}
