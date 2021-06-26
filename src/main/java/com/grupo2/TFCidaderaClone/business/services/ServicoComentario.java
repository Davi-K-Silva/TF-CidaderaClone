package com.grupo2.TFCidaderaClone.business.services;

import com.grupo2.TFCidaderaClone.business.repositorys.IComentarioRepository;
import com.grupo2.TFCidaderaClone.business.repositorys.IReclamacaoRepository;


import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;
import com.grupo2.TFCidaderaClone.business.entities.Comentario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class ServicoComentario {

    @Component
    private IComentarioRepository comentarioRep;
    private IReclamacaoRepository reclamacaoRep;


    @Autowired
    public ServicoComentario(IComentarioRepository comentarioRep,IReclamacaoRepository reclamacaoRep){
        this.comentarioRep = comentarioRep;
        this.reclamacaoRep = reclamacaoRep;

    }

    public boolean cadastra(int id,Comentario comentario){
        Reclamacao reclamacao = reclamacaoRep.findAll().stream().filter(e->e.getId().equals(comentario.getReclamacao())).collect(Collectors.toList()).getIndex(0);
        if(!reclamacao.getStatus().equals("Encerrado")){
            comentarioRep.cadastra(id, comentario);
            return true;
        }
        return false;
    }

    public List<Comentario> todosComentarios(){
        return comentarioRep.todos();
    }
}
