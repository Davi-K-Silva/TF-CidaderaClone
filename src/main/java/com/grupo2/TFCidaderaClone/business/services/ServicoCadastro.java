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

    public boolean cadastrarTestes(){
        Usuario usuario1 = new Usuario (1,"Klark Kent","N");
        Usuario usuario2 = new Usuario (2,"Louis Lane","N");
        Usuario usuario3 = new Usuario(3, "Barry Allen","O");
        Usuario usuario4 = new Usuario(4, "Coringa", "N");
        Usuario usuario5 = new Usuario(5, "Bruce Wayne", "A");

        usuarioRep.cadastra(usuario1);
        usuarioRep.cadastra(usuario2);
        usuarioRep.cadastra(usuario3);
        usuarioRep.cadastra(usuario4);
        usuarioRep.cadastra(usuario5);
        return true;
    }
}