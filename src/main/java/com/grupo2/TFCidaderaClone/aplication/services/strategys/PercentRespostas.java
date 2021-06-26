package com.grupo2.TFCidaderaClone.aplication.services.strategys;

import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PercentRespostas implements IPercentRespostas{

    @Override
    public double calcPercentR(List<Reclamacao> reclamacoes) {
        return 0.0;
    }
}
