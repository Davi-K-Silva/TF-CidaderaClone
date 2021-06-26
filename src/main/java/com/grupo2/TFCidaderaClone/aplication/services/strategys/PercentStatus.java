package com.grupo2.TFCidaderaClone.aplication.services.strategys;

import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class PercentStatus implements IPercentStatus {

    @Override
    public double calcPercentS(List<Reclamacao> reclamacoes, String filtro, String bairro, String categoria) {
        double percentual = 0.0;

        switch (filtro) {
            case "bairro":
                percentual = calculaPercentBairro(reclamacoes, bairro);
                break;
            case "categoria":
                percentual = calculaPercentCategoria(reclamacoes, categoria);
                break;
        }
        return percentual;
    }

    public double calculaPercentCategoria(List<Reclamacao> reclamacoes, String categoria) {
        int numeroReclamacoesPorCategorias = buscaReclamacoesPorCategorias(reclamacoes).size();
        int totalReclamacoes = reclamacoes.size();

        return (numeroReclamacoesPorCategorias * 100) / totalReclamacoes;
    }

    public double calculaPercentBairro(List<Reclamacao> reclamacoes, String bairro) {
        int numeroReclamacoesPorBairros = buscaReclamacoesPorBairros(reclamacoes).size();
        int totalReclamacoes = reclamacoes.size();

        return (numeroReclamacoesPorBairros * 100) / totalReclamacoes;
    }


    public List<Reclamacao> buscaReclamacoesPorCategorias(List<Reclamacao> reclamacoes) {
        return reclamacoes
                .stream()
                .filter(e -> e.getCategoria().toLowerCase(Locale.ROOT) == "encerrada" || e.getCategoria().toLowerCase(Locale.ROOT) == "resolvida")
                .collect(Collectors.toList());
    }

    public List<Reclamacao> buscaReclamacoesPorBairros(List<Reclamacao> reclamacoes) {
        return reclamacoes
                .stream()
                .filter(e -> e.getBairro().toLowerCase(Locale.ROOT) == "encerrada" || e.getBairro().toLowerCase(Locale.ROOT) == "resolvida")
                .collect(Collectors.toList());
    }

}
