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

    public boolean cadastraInicial(){
        Reclamacao reclamacao1 = new Reclamacao(1, "Muito buraco", "Não da pra passar com tanto buraco", "Bom jesus", "rua blablabla 301", "calçada", "Aberto", "Via publica", "https:imgur.com/imagem.jpg", 15, 6, 2021);
        Reclamacao reclamacao2 = new Reclamacao(2, "Sinaleira estragada", "Tudo tranca nessa maldita sinaleira com tempo errado", "Bom Fim", "rua do limoeiro 215", "rua", "Aberto", "Transito", "https:imgur.com/imagem2.jpg", 2, 7, 2021);
        Reclamacao reclamacao3 = new Reclamacao(3, "Arvore caida", "Tem uma arovre tombada que ocupa metade da rua", "Centro", "julio de castilhos 1036", "na frente da padaria", "Aberto", "Via publica", "https:imgur.com/caiu.jpg", 1, 7, 2021);

        reclamacaoRep.cadastra(1, reclamacao1);
        reclamacaoRep.cadastra(1, reclamacao2);
        reclamacaoRep.cadastra(2, reclamacao3);
        return true;
    }
}
