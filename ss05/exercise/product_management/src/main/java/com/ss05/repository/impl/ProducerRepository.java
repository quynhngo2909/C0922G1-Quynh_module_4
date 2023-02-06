package com.ss05.repository.impl;

import com.ss05.model.Producer;
import com.ss05.repository.IProducerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Repository
@Transactional
public class ProducerRepository implements IProducerRepository {
    private static List<Producer> producers;
    static {
        producers = new ArrayList<>();
        producers.add(new Producer((long) 1, "Apple"));
        producers.add(new Producer((long) 2, "Samsung"));
        producers.add(new Producer((long) 3, "Oppo"));
        producers.add(new Producer((long) 4, "LG"));
    }
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Producer> findAll() {
        return producers;
    }

    @Override
    public boolean save(Producer producer) {
        em.persist(producer);
        return true;
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
}
