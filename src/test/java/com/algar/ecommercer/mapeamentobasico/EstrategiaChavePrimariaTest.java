package com.algar.ecommercer.mapeamentobasico;

import com.algar.ecommerce.model.Categoria;
import com.algar.ecommercer.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

public class EstrategiaChavePrimariaTest extends EntityManagerTest {

    @Test
    public void testarEstrategiaAuto(){
        Categoria categoria = new Categoria();

        categoria.setNome("Eletronicos");

        entityManager.getTransaction().begin();
        entityManager.persist(categoria);
        entityManager.getTransaction().commit();

        Categoria categoriaVerificacao = entityManager.find(Categoria.class, categoria.getId());

        Assert.assertNotNull(categoriaVerificacao);
        Assert.assertNotNull(categoriaVerificacao.getNome());
    }
}
