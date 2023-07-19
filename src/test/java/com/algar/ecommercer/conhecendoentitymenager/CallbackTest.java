package com.algar.ecommercer.conhecendoentitymenager;

import com.algar.ecommerce.model.Cliente;
import com.algar.ecommerce.model.Pedido;
import com.algar.ecommerce.model.StatusPedido;
import com.algar.ecommercer.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

public class CallbackTest extends EntityManagerTest {
    @Test
    public void acionarCallbacks() {
        Cliente cliente = entityManager.find(Cliente.class, 1);

        Pedido pedido = new Pedido();

        pedido.setCliente(cliente);
        pedido.setStatus(StatusPedido.AGUARDANDO);

        entityManager.getTransaction().begin();

        entityManager.persist(pedido);
        entityManager.flush();
        pedido.setStatus(StatusPedido.PAGO);

        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());

        Assert.assertNotNull(pedidoVerificacao.getDataCriacao());
        Assert.assertNotNull(pedidoVerificacao.getDataUltimaAtualizacao()   );

    }
}
