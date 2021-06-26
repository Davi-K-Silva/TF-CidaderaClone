package com.grupo2.TFCidaderaClone.business.services.validation;

import com.grupo2.TFCidaderaClone.adapters.repositorys.UsuarioRepository;
import com.grupo2.TFCidaderaClone.business.entities.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class ValidaUsuario implements IValidaUsuario{
    @Component
    private UsuarioRepository usuarioRep;

    @Autowired
    public ValidaUsuario(UsuarioRepository usuarioRep){
        this.usuarioRep = usuarioRep;
    }

    @Override
    public boolean validaUsuario(int id,String tipo){
        Usuario user = usuarioRep.findAll().stream().filter(e->e.getId().equals(id)).collect(Collectors.toList()).getIndex(0);

        if(user.getTipo().equals(tipo))return true;
        else return false;
    }   
}
