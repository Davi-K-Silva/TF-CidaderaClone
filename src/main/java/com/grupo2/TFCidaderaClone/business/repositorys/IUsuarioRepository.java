package com.grupo2.TFCidaderaClone.business.repositorys;

import java.util.List;

import com.grupo2.TFCidaderaClone.business.entities.Usuario;

public interface IUsuarioRepository {
    List<Usuario> todos();
    boolean cadastra(Usuario Usuario);
    void removeTodos();
}
