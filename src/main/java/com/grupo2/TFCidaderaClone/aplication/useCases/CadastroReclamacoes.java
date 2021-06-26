package com.grupo2.TFCidaderaClone.aplication.useCases;

import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;
import com.grupo2.TFCidaderaClone.business.entities.Usuario;
import com.grupo2.TFCidaderaClone.business.services.ServicoReclamacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastroReclamacoes {

    private ServicoReclamacao servRec;

    @Autowired
    public CadastroReclamacoes(ServicoReclamacao servRec){
        this.servRec = servRec;
    }

    public boolean cadastra(Reclamacao reclamacao,Usuario user){
        return servRec.cadastra(reclamacao, user);
    }
}

