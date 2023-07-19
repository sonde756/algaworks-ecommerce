package com.algar.ecommercer.relacionamentos;

import com.algar.ecommerce.model.*;
import com.algar.ecommercer.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class RelacionamentoOneToOneTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento() {
        Pedido  pedido = entityManager.find(Pedido.class,1);

        PagamentoCartao pagamentoCartao = new PagamentoCartao();
        pagamentoCartao.setNumero("1234");
        pagamentoCartao.setStatus(StatusPagamento.PROCESSANDO);
        pagamentoCartao.setPedido(pedido);

        entityManager.getTransaction().begin();
        entityManager.persist(pagamentoCartao);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Pedido pedidoVerificação = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedidoVerificação.getPagamento());


    }

    @Test
    public void verificarRelacionamentoNotaFiscal() {
        Pedido pedido = entityManager.find(Pedido.class,1);

        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setXml("TESTE");
        notaFiscal.setDataEmissao(new Date());
        notaFiscal.setPedido(pedido);

        entityManager.getTransaction().begin();
        entityManager.persist(notaFiscal);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Pedido pedidoVerificação = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedidoVerificação.getNotaFiscal());


    }


}