package com.algar.ecommercer.mapeamentoavancado;

import com.algar.ecommerce.model.Produto;
import com.algar.ecommercer.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ElementCollectionTest extends EntityManagerTest {

    @Test
    public void aplicarTags() {
        entityManager.getTransaction().begin();

        Produto produto = entityManager.find(Produto.class, 1);
        produto.setTags(Arrays.asList("ebook", "livro"));

        entityManager.getTransaction().commit();
        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());

        Assert.assertFalse(produtoVerificacao.getTags().isEmpty());

    }
}
