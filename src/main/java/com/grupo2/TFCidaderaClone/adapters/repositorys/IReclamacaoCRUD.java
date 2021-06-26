package com.grupo2.TFCidaderaClone.adapters.repositorys;

import java.util.List;

import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;

import org.springframework.data.repository.CrudRepository;

public interface IReclamacaoCRUD extends CrudRepository<Reclamacao,Integer>{
    List<Reclamacao> findAll();
    List<Reclamacao> findById(int id);
}
