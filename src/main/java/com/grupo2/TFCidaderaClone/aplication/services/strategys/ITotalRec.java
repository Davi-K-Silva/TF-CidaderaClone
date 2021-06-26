package com.grupo2.TFCidaderaClone.aplication.services.strategys;

import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;

import java.util.List;

public interface ITotalRec {
    public int calcTotal(List<Reclamacao> reclamacoes, String bairro, int tempo);

}
