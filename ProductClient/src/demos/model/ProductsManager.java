/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demos.model;

import demos.db.Products;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.validation.Valid;


/**
 *
 * @author Andre
 */
public class ProductsManager {
    private EntityManager em;
    private Query productNameQuery;
    
   public ProductsManager(String persistenceUnit){
   EntityManagerFactory emf =
        Persistence.createEntityManagerFactory(persistenceUnit);
   em = emf.createEntityManager();
   productNameQuery = em.createNamedQuery("Products.findByName");
   }
   
   public void closeEntityManager(){
       em.close();
   }
    public void create(@Valid Products product) {
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
    }
    public void update(@Valid Products product) {
        em.getTransaction().begin();
        product = em.merge(product);
        em.getTransaction().commit();
    }
    public void delete(@Valid Products product) {
        em.getTransaction().begin();
        em.remove(product);
        em.getTransaction().commit();
    }
    public Products findProduct(Integer id) {
        return em.find(Products.class,id);
    }
    public List<Products> findProductByName(String name){
    productNameQuery.setParameter("name", name);
    return productNameQuery.getResultList();
    }
   }

