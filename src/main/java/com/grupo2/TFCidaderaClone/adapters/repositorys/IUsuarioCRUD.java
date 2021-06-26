package com.grupo2.TFCidaderaClone.adapters.repositorys;

import java.util.List;

import com.grupo2.TFCidaderaClone.business.entities.Usuario;

import org.springframework.data.repository.CrudRepository;

public interface IUsuarioCRUD extends CrudRepository<Usuario,Integer>{
    List<Usuario> findAll();
    List<Usuario> findById(int id);
}
