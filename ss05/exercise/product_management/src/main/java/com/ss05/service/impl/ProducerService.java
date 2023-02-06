package com.ss05.service.impl;

import com.ss05.model.Producer;
import com.ss05.repository.IProducerRepository;
import com.ss05.service.IProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProducerService implements IProducerService {
    @Autowired
    private IProducerRepository producerRepository;
    @Override
    public List<Producer> findAll() {
        return producerRepository.findAll();
    }

    @Override
    public boolean save(Producer producer) {
        return producerRepository.save(producer);
    }

    @Override
    public void update(Long id, Producer producer) {
        producerRepository.update(id, producer);
    }

    @Override
    public void delete(Long id) {
        producerRepository.delete(id);
    }

    @Override
    public Producer findById(Long id) {
        return producerRepository.findById(id);
    }

    @Override
    public List<Producer> findByName(String name) {
        return producerRepository.findByName(name);
    }

    @Override
    public List<String> getProducers() {
        return producerRepository.getProducers();
    }
}
