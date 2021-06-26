package com.grupo2.TFCidaderaClone.aplication.services.strategys;

import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;

import java.util.List;

public interface IPercentStatus {
    public Double calcPercentS(List<Reclamacao> reclamacoes, String bairro, String categoria);

}
