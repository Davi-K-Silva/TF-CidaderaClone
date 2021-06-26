package com.grupo2.TFCidaderaClone.aplication.useCases;

import java.util.List;
import java.util.Map;

import com.grupo2.TFCidaderaClone.business.entities.Comentario;
import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;
import com.grupo2.TFCidaderaClone.business.services.ServicoReclamacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaReclamacoesCompleto {
    private ServicoReclamacao servRec;

    @Autowired
    public ConsultaReclamacoesCompleto(ServicoReclamacao servRec){
        this.servRec = servRec;
    }

    public Map<Reclamacao,List<Comentario>> todasReclamacoesCompleto(){
        return servRec.todasReclamacoesCompleto();
    }
}

