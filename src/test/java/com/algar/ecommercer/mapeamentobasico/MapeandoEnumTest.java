package com.algar.ecommercer.mapeamentobasico;

import com.algar.ecommerce.model.Cliente;
import com.algar.ecommerce.model.SexoCliente;
import com.algar.ecommercer.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

public class MapeandoEnumTest extends EntityManagerTest {

    @Test
    public void testarEnum(){
        Cliente c = new Cliente();
       // c.setId(4);
        c.setNome("Rafael");
        c.setSexo(SexoCliente.MASCULINO);

        entityManager.getTransaction().begin();
        entityManager.persist(c);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, c.getId());

        Assert.assertNotNull(clienteVerificacao);
    }
}
