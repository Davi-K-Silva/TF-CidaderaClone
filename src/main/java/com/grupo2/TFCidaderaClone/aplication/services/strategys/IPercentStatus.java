package com.grupo2.TFCidaderaClone.aplication.services.strategys;

import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;

import java.util.List;

public interface IPercentStatus {
    public double calcPercentS(List<Reclamacao> reclamacoes,String filtro, String bairro, String categoria);

}
