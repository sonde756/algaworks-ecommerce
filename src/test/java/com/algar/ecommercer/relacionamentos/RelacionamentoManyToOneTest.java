package com.algar.ecommercer.relacionamentos;

import com.algar.ecommerce.model.*;
import com.algar.ecommercer.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelacionamentoManyToOneTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento() {
        entityManager.getTransaction().begin();
        Cliente cliente = entityManager.find(Cliente.class, 1);
        Pedido pedido = new Pedido();

        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setDataCriacao(LocalDateTime.now());
        pedido.setCliente(cliente);
        pedido.setTotal(BigDecimal.TEN);


        entityManager.persist(pedido);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());

        Assert.assertNotNull(pedidoVerificacao.getCliente());
    }

    @Test
    public void verificarRelacionamentoPedido() {
        Cliente cliente = entityManager.find(Cliente.class, 1);
        Produto produto = entityManager.find(Produto.class, 3);

        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setDataCriacao(LocalDateTime.now());
        pedido.setCliente(cliente);
        pedido.setTotal(BigDecimal.TEN);

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setId(new ItemPedidoId());
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);
        itemPedido.setQuantidade(1);
        itemPedido.setPrecoProduto(produto.getPreco());

        entityManager.getTransaction().begin();
        entityManager.persist(itemPedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerifi = entityManager.find(Pedido.class, pedido.getId());

        Assert.assertFalse(pedidoVerifi.getItens().isEmpty());

    }
}
