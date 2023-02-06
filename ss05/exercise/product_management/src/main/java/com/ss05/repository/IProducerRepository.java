package com.ss05.repository;

import com.ss05.model.Producer;

import java.util.List;

public interface IProducerRepository extends IGeneralRepository<Producer> {
    List<String> getProducers();
}
