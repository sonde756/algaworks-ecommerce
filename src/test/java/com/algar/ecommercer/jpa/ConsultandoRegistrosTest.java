package com.algar.ecommercer.jpa;

import com.algar.ecommercer.EntityManagerTest;
import com.algar.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

public class ConsultandoRegistrosTest extends EntityManagerTest {


    @Test
    public void buscarPorIdentificador() {

        Produto produto = entityManager.find(Produto.class, 1);

        Assert.assertNotNull(produto);
        Assert.assertEquals("Kindle", produto.getNome());
    }

    @Test
    public void atualizarReferencia() {
        Produto produto = entityManager.find(Produto.class, 1);
        produto.setNome("Micro");
        entityManager.refresh(produto);

        Assert.assertEquals("Kindle", produto.getNome());

    }
}
