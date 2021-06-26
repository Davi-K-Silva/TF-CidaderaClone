package com.grupo2.TFCidaderaClone.business.services;

import com.grupo2.TFCidaderaClone.business.repositorys.IComentarioRepository;
import com.grupo2.TFCidaderaClone.business.repositorys.IReclamacaoRepository;


import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;
import com.grupo2.TFCidaderaClone.business.entities.Comentario;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoComentario {

    private IComentarioRepository comentarioRep;
    private IReclamacaoRepository reclamacaoRep;


    @Autowired
    public ServicoComentario(IComentarioRepository comentarioRep,IReclamacaoRepository reclamacaoRep){
        this.comentarioRep = comentarioRep;
        this.reclamacaoRep = reclamacaoRep;

    }

    public boolean cadastra(int idUser,int idRec,Comentario comentario){
        Reclamacao reclamacao = reclamacaoRep.todos().stream().filter(e->e.getId() == idRec).collect(Collectors.toList()).get(0);
        if(!reclamacao.getStatus().equals("Encerrado")){
            comentarioRep.cadastra(idUser,idRec, comentario);
            return true;
        }
        return false;
    }

    public List<Comentario> todosComentarios(){
        return comentarioRep.todos();
    }

    public boolean cadastraInicial(){
        Comentario comentario1 = new Comentario(1,"Meu deus que cara burro","");
        Comentario comentario2 = new Comentario(2,"Realmente","");
        Comentario comentario3 = new Comentario(3,"Eu que botei, droga, descobriram ...", "");

        comentarioRep.cadastra(2, 1, comentario1);
        comentarioRep.cadastra(3, 1, comentario2);
        comentarioRep.cadastra(4, 3, comentario3);
        return true;
    }
}
