package com.algar.ecommercer.mapeamentobasico;

import com.algar.ecommerce.model.Cliente;
import com.algar.ecommerce.model.EnderecoEntregaPedido;
import com.algar.ecommerce.model.Pedido;
import com.algar.ecommerce.model.StatusPedido;
import com.algar.ecommercer.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MapeamentoObjetoEmbutidoTest extends EntityManagerTest {

    @Test
    public void analisarMapeamentoObjetoEmbutido(){
        Cliente cliente = entityManager.find(Cliente.class,1);
        EnderecoEntregaPedido entregaPedido = new EnderecoEntregaPedido();
        entregaPedido.setCep("000-000");
        entregaPedido.setComplemento("casa");
        entregaPedido.setCidade("serra");
        entregaPedido.setEstado("Rn");
        entregaPedido.setLogradouro("Longra");
        entregaPedido.setNumero("60");




        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        //pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setTotal(new BigDecimal(1000));
        pedido.setEnderecoEntrega(entregaPedido);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());

        Assert.assertNotNull(pedidoVerificacao);
        Assert.assertNotNull(pedidoVerificacao.getEnderecoEntrega());
        Assert.assertNotNull(pedidoVerificacao.getEnderecoEntrega().getCep());


    }

}
