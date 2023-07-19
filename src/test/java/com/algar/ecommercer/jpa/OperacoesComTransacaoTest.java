package com.algar.ecommercer.jpa;

import com.algar.ecommercer.EntityManagerTest;
import com.algar.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperacoesComTransacaoTest extends EntityManagerTest {


    @Test
    public void impedirOperacaoComBancoDeDados() {
        Produto p = entityManager.find(Produto.class, 1);
        entityManager.detach(p);

        p.setNome("Kindle paperwhite 2");


        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();

        entityManager.clear();
        Produto produtoVerificacao = entityManager.find(Produto.class, p.getId());
        Assert.assertEquals("Kindle", produtoVerificacao.getNome());
    }

    @Test
    public void diferencaMergeEpersist() {
        Produto produtoPersist = new Produto();

       // produtoPersist.setId(5);
        produtoPersist.setNome("SmartPhone");
        produtoPersist.setDescricao("SnapDragon 885");
        produtoPersist.setPreco(new BigDecimal(2229.99));

        entityManager.getTransaction().begin();

        entityManager.persist(produtoPersist);

        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacaoPersist = entityManager.find(Produto.class, produtoPersist.getId());
        Assert.assertNotNull(produtoVerificacaoPersist);


        Produto produtoMerge = new Produto();

        produtoMerge.setId(6);
        produtoMerge.setNome("NoteBook");
        produtoMerge.setDescricao("Não é posi");
        produtoMerge.setPreco(new BigDecimal(229.99));

        entityManager.getTransaction().begin();

        entityManager.merge(produtoMerge);

        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacaoMerge = entityManager.find(Produto.class, produtoMerge.getId());
        Assert.assertNotNull(produtoVerificacaoMerge);

    }

    @Test
    public void inseriObjetoComMerge() {
        Produto p = new Produto();

        p.setId(4);
        p.setNome("Microfone");
        p.setDescricao("O Melhor");
        p.setPreco(new BigDecimal(29.99));

        entityManager.getTransaction().begin();

        entityManager.merge(p);

        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, p.getId());
        Assert.assertNotNull(produtoVerificacao);
    }

    @Test
    public void atualizarObjetoGerenciado() {
        Produto p = entityManager.find(Produto.class, 1);

        p.setNome("Kindle paperwhite 2");


        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();

        entityManager.clear();
        Produto produtoVerificacao = entityManager.find(Produto.class, p.getId());
        Assert.assertEquals("Kindle paperwhite 2", produtoVerificacao.getNome());
    }

    @Test
    public void atualizarObjeto() {
        Produto p = new Produto();
        p.setId(1);
        p.setNome("Kindle paperwhite");
        p.setDescricao("A melhor atualmente");
        p.setPreco(new BigDecimal(899.99));

        entityManager.getTransaction().begin();
        entityManager.merge(p);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, p.getId());
        Assert.assertNotNull(produtoVerificacao);
        Assert.assertEquals("Kindle paperwhite", produtoVerificacao.getNome());
    }

    @Test
    public void removerObjeto() {
        Produto p = entityManager.find(Produto.class, 3);


        entityManager.getTransaction().begin();

        entityManager.remove(p);

        entityManager.getTransaction().commit();

        //entityManager.clear(); não é necessário na asserção de remoção.

        Produto produtoVerificacao = entityManager.find(Produto.class, 3);

        Assert.assertNull(produtoVerificacao);
    }

    @Test
    public void inserirPrimerioObjeto() {
        Produto p = new Produto();

        //p.setId(2);
        p.setNome("Caneca");
        p.setDescricao("Melhor caneca");
        p.setPreco(new BigDecimal(19.99));

        entityManager.getTransaction().begin();

        entityManager.persist(p);

        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, p.getId());
        Assert.assertNotNull(produtoVerificacao);
    }

    @Test
    public void abrirEfecharTransacao() {
        Produto p = new Produto();

        entityManager.getTransaction().begin();

        /*entityManager.persist(p);
        entityManager.merge(p);
        entityManager.remove(p);*/

        entityManager.getTransaction().commit();
    }
}
