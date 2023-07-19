package com.algar.ecommercer.relacionamentos;

import com.algar.ecommerce.model.Categoria;
import com.algar.ecommerce.model.Pedido;
import com.algar.ecommercer.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

public class RemovendoEntidadeReferenciadaTest extends EntityManagerTest {

    @Test
    public void removerEntidadeRelacionada() {
        Pedido pedido = entityManager.find(Pedido.class, 1);



        entityManager.getTransaction().begin();
        pedido.getItens().forEach(i -> entityManager.remove(i));
        entityManager.remove(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, 1);
        Assert.assertNull(pedidoVerificacao);

    }

}
