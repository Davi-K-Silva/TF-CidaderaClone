package com.grupo2.TFCidaderaClone.business.services;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;
import com.grupo2.TFCidaderaClone.business.entities.Usuario;
import com.grupo2.TFCidaderaClone.business.entities.Comentario;
import com.grupo2.TFCidaderaClone.business.repositorys.IComentarioRepository;
import com.grupo2.TFCidaderaClone.business.repositorys.IReclamacaoRepository;
import com.grupo2.TFCidaderaClone.business.services.validation.IValidaUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoReclamacao {
    
    private IReclamacaoRepository reclamacaoRep;
    private IComentarioRepository comentarioRep;
    private IValidaUsuario validaUsuario;

    @Autowired
    public ServicoReclamacao(IReclamacaoRepository reclamacaoRep,IComentarioRepository comentarioRep,IValidaUsuario validaUsuario){
        this.reclamacaoRep = reclamacaoRep;
        this.comentarioRep = comentarioRep;
        this.validaUsuario = validaUsuario;
    }

    public boolean atualizar(Reclamacao reclamacao,int usuario){
        Reclamacao reclamacaoAnt = reclamacaoRep.todos().stream().filter(e->e.getId() == reclamacao.getId()).collect(Collectors.toList()).get(0);

        if(!reclamacaoAnt.getStatus().equals("Encerrado")){
            if(reclamacao.getStatus().equals("Encerrado")){
                if(validaUsuario.validaUsuario(usuario,"A")){
                    reclamacaoRep.atualiza(usuario, reclamacao);
                    return true;
                }
            }
            else{
                reclamacaoRep.atualiza(usuario, reclamacao);
                return true;
            }
        }

        return false;
    }
    
    public boolean cadastra(Reclamacao reclamacao,int idUs){
        reclamacaoRep.cadastra(idUs, reclamacao);
        return true;
    }

    public List<Reclamacao> todasReclamacoes(){
        return reclamacaoRep.todos();
    }

    public Map<Reclamacao,List<Comentario>> todasReclamacoesCompleto(){

        Map<Reclamacao,List<Comentario>> dict = new HashMap<Reclamacao,List<Comentario>>();
        
        for (Reclamacao reclamacao:reclamacaoRep.todos()){
            dict.put(reclamacao,comentarioRep.todos().stream().filter(e->e.getReclamacao() == reclamacao.getId()).collect(Collectors.toList())); 
        }
        
        return dict;
    }

    public Map<Reclamacao,List<Comentario>> getReclamacao(int id){

        Map<Reclamacao,List<Comentario>> dict = new HashMap<Reclamacao,List<Comentario>>();
        dict.put(reclamacaoRep.todos().stream().filter(e->e.getId() == id).collect(Collectors.toList()).get(0)
                    ,comentarioRep.todos().stream().filter(e->e.getReclamacao() == id).collect(Collectors.toList()));

        return dict;
    }
}
