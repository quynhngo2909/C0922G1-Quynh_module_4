package com.ss05.repository.impl;

import com.ss05.model.Producer;
import com.ss05.repository.IProducerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProducerRepository implements IProducerRepository {
    private static Map<Long, Producer> producers;
    static {
        producers = new HashMap<>();
        producers.put(1L, new Producer(1L, "Apple"));
        producers.put(2L, new Producer(2L, "Samsung"));
        producers.put(3L, new Producer(3L, "Oppo"));
        producers.put(4L, new Producer(4L, "LG"));
    }

    @Override
    public List<Producer> findAll() {
        return new ArrayList<>(producers.values());
    }

    @Override
    public boolean save(Producer producer) {
        producers.put(producer.getId(), producer);
        return  true;
    }

    @Override
    public void update(Long id, Producer producer) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Producer findById(Long id) {
        return null;
    }

    @Override
    public List<Producer> findByName(String name) {
        return null;
    }

    @Override
    public List<String> getProducers() {
        List<String> producers = new ArrayList<>();
        List<Producer> producers1 = findAll();
        for (Producer p:producers1) {
            producers.add(p.getName());
        }
        return producers;
    }
}
