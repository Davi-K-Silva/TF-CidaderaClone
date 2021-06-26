package com.grupo2.TFCidaderaClone.aplication.useCases;

import com.grupo2.TFCidaderaClone.business.entities.Usuario;
import com.grupo2.TFCidaderaClone.business.services.ServicoCadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class CadastraUsuario {
    
    @Component
    private ServicoCadastro servCad;

    @Autowired
    public CadastraUsuario(ServicoCadastro servCad){
        this.servCad = servCad;
    }

    public boolean cadastra(Usuario user, int id){
        return servCad.cadastra(user, id);
    }
}
