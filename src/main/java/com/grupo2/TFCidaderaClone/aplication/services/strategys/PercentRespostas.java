package com.grupo2.TFCidaderaClone.aplication.services.strategys;

import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Component
public class PercentRespostas implements IPercentRespostas{

    @Override
    public double calcPercentR(List<Reclamacao> reclamacoes) {
        int totalReclamacoes = reclamacoes.size();
        int totalReclamacoesEncerradas = buscaReclamacoesEncerradas(reclamacoes).size();
        return (double) (totalReclamacoesEncerradas * 100)/totalReclamacoes;
    }

    public List<Reclamacao> buscaReclamacoesEncerradas(List<Reclamacao> reclamacoes){
        return reclamacoes
                .stream()
                .filter(e->e.getStatus().toLowerCase(Locale.ROOT).equals("encerrada"))
                .collect(Collectors.toList());
    }

}
