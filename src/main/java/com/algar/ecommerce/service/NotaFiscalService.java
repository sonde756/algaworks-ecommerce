package com.algar.ecommerce.service;

import com.algar.ecommerce.model.Pedido;

public class NotaFiscalService {

    public void gerar(Pedido pedido){
        System.out.println("Gerando nota fiscal para pedido "+pedido.getId()+".");
    }
}
