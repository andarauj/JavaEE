/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demos.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Andre
 */
public class ProductManager {
    private EntityManager em;
    private Query productNameQuery;
    
   public ProductManager(String persistenceUnit){
   EntityManagerFactory emf =
        Persistence.createEntityManagerFactory(persistenceUnit);
   em = emf.createEntityManager();
   productNameQuery = em.createNamedQuery("Product.findByName");
   }
   
   public void closeEntityManager(){
       em.close();
   }
      
   }

