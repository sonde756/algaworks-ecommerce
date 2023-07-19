package com.algar.ecommercer.mapeamentoavancado;

import com.algar.ecommerce.model.*;
import com.algar.ecommercer.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class ChaveCompostaTest extends EntityManagerTest {

    @Test
    public void salvarItem() {
        entityManager.getTransaction().begin();

        Cliente cliente = entityManager.find(Cliente.class, 1);
        Produto produto = entityManager.find(Produto.class, 1);

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataCriacao(LocalDateTime.now());
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setTotal(produto.getPreco());


        ItemPedido itemPedido = new ItemPedido();

        itemPedido.setId(new ItemPedidoId());
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);
        itemPedido.setPrecoProduto(produto.getPreco());
        itemPedido.setQuantidade(1);

        entityManager.persist(itemPedido);

        entityManager.getTransaction().commit();
    }

    @Test
    public void buscarItem() {
        ItemPedido itemPedido = entityManager.find(ItemPedido.class, new ItemPedidoId(1, 1));

        Assert.assertNotNull(itemPedido);
    }
}
