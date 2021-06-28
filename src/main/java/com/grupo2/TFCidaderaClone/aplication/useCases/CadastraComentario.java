package com.grupo2.TFCidaderaClone.aplication.useCases;

import com.grupo2.TFCidaderaClone.business.entities.Comentario;
import com.grupo2.TFCidaderaClone.business.services.ServicoComentario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraComentario {
    
    private ServicoComentario servCom;

    @Autowired
    public CadastraComentario(ServicoComentario servCom){
        this.servCom = servCom;
    }

    public boolean cadastra(int idUser,int idRec,Comentario comentario){
        return servCom.cadastra(idUser, idRec, comentario);

    }

    public boolean cadastraInicial(){
        return servCom.cadastraInicial();
    }
}
