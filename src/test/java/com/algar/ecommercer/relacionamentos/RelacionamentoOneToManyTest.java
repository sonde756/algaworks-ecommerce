package com.algar.ecommercer.relacionamentos;

import com.algar.ecommerce.model.*;
import com.algar.ecommercer.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelacionamentoOneToManyTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento() {
        Cliente cliente = entityManager.find(Cliente.class, 1);
        Pedido pedido = new Pedido();

        pedido.setStatus(StatusPedido.AGUARDANDO);
        //    pedido.setDataPedido(LocalDateTime.now());
        pedido.setCliente(cliente);
        pedido.setTotal(BigDecimal.TEN);


        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Cliente clienteVerifi = entityManager.find(Cliente.class, cliente.getId());

        Assert.assertFalse(clienteVerifi.getPedidos().isEmpty());
    }

    @Test
    public void verificarRelacionamentoItemPedido() {
        entityManager.getTransaction().begin();

        Cliente cliente = entityManager.find(Cliente.class, 1);
        Produto produto = entityManager.find(Produto.class, 1);

        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setDataCriacao(LocalDateTime.now());
        pedido.setCliente(cliente);
        pedido.setTotal(BigDecimal.TEN);



        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setId(new ItemPedidoId());
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);
        itemPedido.setPrecoProduto(produto.getPreco());
        itemPedido.setQuantidade(1);



        entityManager.persist(pedido);
        entityManager.persist(itemPedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        ItemPedido itemPedidoVerifi = entityManager.find(ItemPedido.class, new ItemPedidoId(1, 1));

        Assert.assertNotNull(itemPedidoVerifi.getId().getProdutoId());
        Assert.assertNotNull(itemPedidoVerifi.getId().getPedidoId());
    }
}
