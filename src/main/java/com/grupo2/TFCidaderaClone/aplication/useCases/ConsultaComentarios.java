package com.grupo2.TFCidaderaClone.aplication.useCases;

import java.util.List;

import com.grupo2.TFCidaderaClone.business.entities.Comentario;
import com.grupo2.TFCidaderaClone.business.services.ServicoComentario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class ConsultaComentarios {
    @Component
    private ServicoComentario servCom;

    @Autowired
    public ConsultaComentarios(ServicoComentario servCom){
        this.servCom = servCom;
    }

    public List<Comentario> todosComentario(){
        return servCom.todosComentarios();
    }
}

