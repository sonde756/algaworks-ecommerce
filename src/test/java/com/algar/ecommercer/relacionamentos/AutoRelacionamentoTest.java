package com.algar.ecommercer.relacionamentos;

import com.algar.ecommerce.model.*;
import com.algar.ecommercer.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AutoRelacionamentoTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento() {
        Categoria categoriaPai = new Categoria();
        categoriaPai.setNome("Eletronicos");

        Categoria categoria = new Categoria();
        categoria.setNome("Celulares");
        categoria.setCategoriaPai(categoriaPai);



        entityManager.getTransaction().begin();
        entityManager.persist(categoriaPai);
        entityManager.persist(categoria);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Categoria categoriaVerifi = entityManager.find(Categoria.class, categoria.getId());

        Assert.assertNotNull(categoriaVerifi.getCategoriaPai());
    }

}
