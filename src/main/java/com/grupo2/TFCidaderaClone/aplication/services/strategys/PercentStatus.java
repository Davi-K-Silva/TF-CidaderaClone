package com.grupo2.TFCidaderaClone.aplication.services.strategys;

import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;

import java.util.List;

public class PercentStatus implements IPercentStatus{

    @Override
    public double calcPercentS(List<Reclamacao> reclamacoes,String filtro, String bairro, String categoria) {
        return 0.0;
    }
}
