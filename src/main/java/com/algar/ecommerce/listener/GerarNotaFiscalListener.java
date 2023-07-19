package com.algar.ecommerce.listener;

import com.algar.ecommerce.model.Pedido;
import com.algar.ecommerce.service.NotaFiscalService;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class GerarNotaFiscalListener {

    private NotaFiscalService notaFiscalService = new NotaFiscalService();

    @PreUpdate
    @PrePersist
    public void gerar(Pedido pedido) {
        if (pedido.isPago() && pedido.getNotaFiscal() == null){
            notaFiscalService.gerar(pedido);
        }
    }
}
