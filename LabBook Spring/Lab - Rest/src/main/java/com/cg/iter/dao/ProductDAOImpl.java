package com.cg.iter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.iter.entities.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @PersistenceContext
    private EntityManager em;
    
    public void save(Product p) {
        em.persist(p);
        em.flush();
    }

    public Product findById(Integer productId) {
        return em.find(Product.class, productId);
    }

    public List<Product> findAll() {
        Query q = em.createQuery("from Product p");
        return q.getResultList();
    }
}