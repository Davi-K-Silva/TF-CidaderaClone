package com.grupo2.TFCidaderaClone.aplication.useCases;

import java.util.List;
import java.util.Map;

import com.grupo2.TFCidaderaClone.business.entities.Comentario;
import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;
import com.grupo2.TFCidaderaClone.business.services.ServicoReclamacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class ConsultaReclamacao {
    @Component
    private ServicoReclamacao servRec;

    @Autowired
    public ConsultaReclamacao(ServicoReclamacao servRec){
        this.servRec = servRec;
    }

    public Map<Reclamacao,List<Comentario>> getReclamacao(int id){
        return servRec.getReclamacao(id);
    }
}

