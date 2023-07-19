package com.algar.ecommercer.relacionamentos;

import com.algar.ecommerce.model.Categoria;
import com.algar.ecommerce.model.Pedido;
import com.algar.ecommercer.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

public class EagerELazyTest extends EntityManagerTest {

    @Test
    public void verificarComportamento() {
        Pedido pedido = entityManager.find(Pedido.class,1);

    }

}
