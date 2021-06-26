package com.grupo2.TFCidaderaClone.business.services;

import com.grupo2.TFCidaderaClone.business.entities.Usuario;
import com.grupo2.TFCidaderaClone.business.repositorys.IUsuarioRepository;
import com.grupo2.TFCidaderaClone.business.services.validation.IValidaUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoCadastro {
    
    private IUsuarioRepository usuarioRep;
    private IValidaUsuario validaUsuario;

    @Autowired
    public ServicoCadastro(IUsuarioRepository usuarioRep, IValidaUsuario validaUsuario){
        this.usuarioRep = usuarioRep;
        this.validaUsuario = validaUsuario;
    }

    public boolean cadastra(Usuario user,int id){
        if(user.getTipo().equals("O")){
            if (validaUsuario.validaUsuario(id, "A")){
                usuarioRep.cadastra(user);
                return true;
            }      
        }
        else{
            usuarioRep.cadastra(user);
            return true;
        }
        return false;
    }
}