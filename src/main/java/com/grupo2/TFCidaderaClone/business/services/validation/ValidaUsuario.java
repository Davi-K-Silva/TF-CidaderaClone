package com.grupo2.TFCidaderaClone.business.services.validation;

import java.util.stream.Collectors;

import com.grupo2.TFCidaderaClone.adapters.repositorys.UsuarioRepository;
import com.grupo2.TFCidaderaClone.business.entities.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaUsuario implements IValidaUsuario{
    private UsuarioRepository usuarioRep;

    @Autowired
    public ValidaUsuario(UsuarioRepository usuarioRep){
        this.usuarioRep = usuarioRep;
    }

    @Override
    public boolean validaUsuario(int id,String tipo){
        Usuario user = usuarioRep.todos().stream().filter(e->e.getId() == id).collect(Collectors.toList()).get(0);
        
        if(user.getTipo().equals(tipo))return true;
        else return false;
    }   
}
