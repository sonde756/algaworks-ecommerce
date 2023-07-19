package com.algar.ecommercer.mapeamentoavancado;

import com.algar.ecommerce.model.Cliente;
import com.algar.ecommercer.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

public class PropriedadesTransientTest extends EntityManagerTest {

    @Test
    public void validarPrimerioNome() {

        Cliente cliente = entityManager.find(Cliente.class, 1);

        Assert.assertEquals("Hudson", cliente.getPrimeiroNome());
    }
}
