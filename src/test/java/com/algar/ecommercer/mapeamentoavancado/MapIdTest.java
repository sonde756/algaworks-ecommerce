package com.algar.ecommercer.mapeamentoavancado;

import com.algar.ecommerce.model.*;
import com.algar.ecommercer.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Date;

public class MapIdTest extends EntityManagerTest {

    @Test
    public void inserirPagamento() {
        Pedido pedido = entityManager.find(Pedido.class, 1);

        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setPedido(pedido);
        notaFiscal.setXml("xml");
        notaFiscal.setDataEmissao(new Date());

        entityManager.getTransaction().begin();
        entityManager.persist(notaFiscal);
        entityManager.getTransaction().commit();

        entityManager.clear();

        NotaFiscal notaFiscalVerifi = entityManager.find(NotaFiscal.class, notaFiscal.getId());
        Assert.assertNotNull(notaFiscalVerifi);
        Assert.assertEquals(pedido.getId(), notaFiscalVerifi.getId());
    }


    @Test
    public void inerirItemPedido() {
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

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.persist(itemPedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        ItemPedido itemPedidoVerifica = entityManager.find(ItemPedido.class,
                                        new ItemPedidoId(pedido.getId(), produto.getId()));

        Assert.assertNotNull(itemPedidoVerifica);


    }
}
