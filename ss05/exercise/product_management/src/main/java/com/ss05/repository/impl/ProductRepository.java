package com.ss05.repository.impl;

import com.ss05.model.Product;
import com.ss05.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Product> findAll() {
        return em.createQuery("select p from Product p").getResultList();
    }

    @Override
    public boolean save(Product product) {
        if(product.getId() == null) {
            em.persist(product);
            return true;
        }

        Product product1 = findById(product.getId());
        if (product1 == null) {
            return false;
        } else {
            em.detach(product1);
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
            product1.setProducer(product.getProducer());
            em.merge(product1);
            return  true;
        }
    }

    @Override
    public void update(Long id, Product product) {
    }

    @Override
    public void delete(Long id) {
        em.remove(findById(id));
    }

    @Override
    public Product findById(Long id) {
        return em.find(Product.class, id);
    }

    @Override
    public List<Product> findByName(String name) {
        return em.createQuery("select p from  Product  p where p.name like :name").setParameter("name", '%' + name + '%').getResultList();
    }
}
