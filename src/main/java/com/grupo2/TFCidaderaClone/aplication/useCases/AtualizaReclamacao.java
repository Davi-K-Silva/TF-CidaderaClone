package com.grupo2.TFCidaderaClone.aplication.useCases;

import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;
import com.grupo2.TFCidaderaClone.business.entities.Usuario;
import com.grupo2.TFCidaderaClone.business.services.ServicoReclamacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class AtualizaReclamacao {
    @Component
    private ServicoReclamacao servRec;

    @Autowired
    public AtualizaReclamacao(ServicoReclamacao servRec){
        this.servRec = servRec;
    }

    public boolean atualizar(Reclamacao reclamacao,Usuario user){
        return servRec.atualizar(reclamacao, user);
    }
}
