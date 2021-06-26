package com.grupo2.TFCidaderaClone.adapters.repositorys;

import java.util.List;

import com.grupo2.TFCidaderaClone.business.entities.Usuario;
import com.grupo2.TFCidaderaClone.business.repositorys.IUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioRepository implements IUsuarioRepository{
    private IUsuarioCRUD usuarioCRUD;

    @Autowired
    public UsuarioRepository(IUsuarioCRUD usuarioCRUD) {
        this.usuarioCRUD = usuarioCRUD;

        Usuario usuario1 = new Usuario (1,"Klark Kent","N");
        Usuario usuario2 = new Usuario (2,"Louis Lane","N");
        Usuario usuario3 = new Usuario(3, "Barry Allen","O");
        Usuario usuario4 = new Usuario(4, "Coringa", "N");
        Usuario usuario5 = new Usuario(5, "Bruce Wayne", "A");

        cadastra(usuario1);
        cadastra(usuario2);
        cadastra(usuario3);
        cadastra(usuario4);
        cadastra(usuario5);
    }

    public List<Usuario> todos() {
        return usuarioCRUD.findAll();
    }

    public void removeTodos(){
        usuarioCRUD.deleteAll();
    }

    public boolean cadastra(Usuario usuario){
        usuarioCRUD.save(usuario);
        return true;
    }
}
