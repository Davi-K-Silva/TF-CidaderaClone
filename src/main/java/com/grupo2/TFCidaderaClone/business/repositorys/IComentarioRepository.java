package com.grupo2.TFCidaderaClone.business.repositorys;

import java.util.List;

import com.grupo2.TFCidaderaClone.business.entities.Comentario;

public interface IComentarioRepository {
    List<Comentario> todos();
    boolean cadastra(int idUs, int idRec, Comentario comentario);
    void removeTodos();
}

