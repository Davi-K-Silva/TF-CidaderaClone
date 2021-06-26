package com.grupo2.TFCidaderaClone.business.services;

import java.util.List;
import java.util.Map;

import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;
import com.grupo2.TFCidaderaClone.business.entities.Usuario;
import com.grupo2.TFCidaderaClone.business.entities.Comentario;
import com.grupo2.TFCidaderaClone.business.repositorys.IComentarioRepository;
import com.grupo2.TFCidaderaClone.business.repositorys.IReclamacaoRepository;
import com.grupo2.TFCidaderaClone.business.services.validation.IValidaUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class ServicoReclamacao {
    
    @Component
    private IReclamacaoRepository reclamacaoRep;
    private IComentarioRepository comentarioRep;
    private IValidaUsuario validaUsuario;

    @Autowired
    public ServicoReclamacao(IReclamacaoRepository reclamacaoRep,IComentarioRepository comentarioRep,IValidaUsuario validaUsuario){
        this.reclamacaoRep = reclamacaoRep;
        this.comentarioRep = comentarioRep;
        this.validaUsuario = validaUsuario;
    }

    public boolean atualizar(Reclamacao reclamacao,Usuario usuario){
        Reclamacao reclamacaoAnt = reclamacaoRep.findAll().stream().filter(e->e.getId().equals(reclamacao.getId())).collect(Collectors.toList()).getIndex(0);

        if(!reclamacaoAnt.getStatus().equals("Encerrado")){
            if(reclamacao.getStatus().equals("Encerrado")){
                if(validaUsuario.validaUsuario(usuario.getId(),"A")){
                    reclamacaoRep.atualiza(usuario.getId(), reclamacao);
                    return true;
                }
            }
            else{
                reclamacaoRep.atualiza(usuario.getId(), reclamacao);
                return true;
            }
        }

        return false;
    }
    
    public boolean cadastra(Reclamacao reclamacao,Usuario usuario){
        reclamacaoRep.cadastra(usuario.getId(), reclamacao);
        return true;
    }

    public List<Reclamacao> todasReclamacoes(){
        return reclamacaoRep.todos();
    }

    public Map<Reclamacao,List<Comentario>> todasReclamacoesCompleto(){

        Map<Reclamacao,List<Comentario>> dict = new HashMap<Reclamacao,List<Comentario>>();
        
        for (Reclamacao reclamacao:reclamacaoRep.todos()){
            ditc.put(reclamacao.getId(),comentarioRep.findAll().stream().filter(e->e.getReclamacao.equals(reclamacao.getId())).collect(Collectors.toList())); 
        }
        
        return dict;
    }

    public Map<Reclamacao,List<Comentario>> getReclamacao(int id){

        Map<Reclamacao,List<Comentario>> dict = new HashMap<Reclamacao,List<Comentario>>();
        
        ditc.put(reclamacao.getId(),comentarioRep.findAll().stream().filter(e->e.getReclamacao.equals(id)).collect(Collectors.toList())); 

        return dict;
    }
}
