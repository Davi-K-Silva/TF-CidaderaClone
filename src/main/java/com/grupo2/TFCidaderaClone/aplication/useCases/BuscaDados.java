package com.grupo2.TFCidaderaClone.aplication.useCases;

import com.grupo2.TFCidaderaClone.aplication.services.ServicoEstatistica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class BuscaDados {
    @Component
    private ServicoEstatistica servEstat;

    @Autowired
    public BuscaDados(ServicoEstatistica servEstat){
        this.servEstat = servEstat;
    }

}
