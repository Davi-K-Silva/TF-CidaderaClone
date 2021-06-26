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
