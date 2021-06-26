package com.grupo2.TFCidaderaClone.business.repositorys;

import java.util.List;

import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;

public interface IReclamacaoRepository {
    List<Reclamacao> todos();
    boolean cadastra(int id,Reclamacao reclamacao);
    boolean atualiza(int id,Reclamacao reclamacao);
    void removeTodos();
}
