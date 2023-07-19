package com.algar.ecommerce.model.util;

import com.algar.ecommerce.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class UnidadeDePersistencia {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ecommerce-PU");
        EntityManager em = emf.createEntityManager();

        Produto produto = em.find(Produto.class, 1);
        System.out.println(produto.getNome());

        em.close();
        emf.close();
    }
}
