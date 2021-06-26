package com.grupo2.TFCidaderaClone.aplication.useCases;

import java.util.List;

import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;
import com.grupo2.TFCidaderaClone.business.services.ServicoReclamacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaReclamacoes {
    private ServicoReclamacao servRec;

    @Autowired
    public ConsultaReclamacoes(ServicoReclamacao servRec){
        this.servRec = servRec;
    }

    public List<Reclamacao> todasReclamacoes(){
        return servRec.todasReclamacoes();
    }
}







