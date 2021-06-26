package com.grupo2.TFCidaderaClone.adapters.repositorys;

import java.util.List;

import com.grupo2.TFCidaderaClone.business.entities.Comentario;

import org.springframework.data.repository.CrudRepository;

public interface IComentarioCRUD extends CrudRepository<Comentario,Integer>{
    List<Comentario> findAll();
    List<Comentario> findById(int id);
}
