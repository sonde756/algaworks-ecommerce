package com.algar.ecommercer.jpa;

import com.algar.ecommerce.model.Cliente;
import com.algar.ecommerce.model.Produto;
import com.algar.ecommercer.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

public class PrimeiroCrudTest extends EntityManagerTest {


    @Test
    public void atualizarObj() {

        Cliente c = new Cliente();
        c.setNome("Rafael");
        //c.setId(3);

        entityManager.getTransaction().begin();
        entityManager.merge(c);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Cliente clienteVerificação = entityManager.find(Cliente.class, c.getId());

        Assert.assertNotNull(clienteVerificação);
        Assert.assertEquals("Rafael", clienteVerificação.getNome());
    }

    @Test
    public void removerObj() {
        Cliente p = entityManager.find(Cliente.class, 1);


        entityManager.getTransaction().begin();

        entityManager.remove(p);

        entityManager.getTransaction().commit();

        //entityManager.clear(); não é necessário na asserção de remoção.

        Cliente clienteVerificação = entityManager.find(Cliente.class, 1);

        Assert.assertNull(clienteVerificação);
    }

    @Test
    public void adicionarObj() {
        Cliente cliente = new Cliente();
       // cliente.setId(3);
        cliente.setNome("Edson");

        entityManager.persist(cliente);
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();

        Produto produtoVerificacao = entityManager.find(Produto.class, cliente.getId());
        Assert.assertNotNull(produtoVerificacao);
    }

    @Test
    public void ConsultarObj(){
        Cliente p = entityManager.find(Cliente.class, 2);

        Assert.assertEquals("Anderson",p.getNome());
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();

    }

}
