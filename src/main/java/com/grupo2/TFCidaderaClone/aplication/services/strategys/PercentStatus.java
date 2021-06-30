package com.grupo2.TFCidaderaClone.aplication.services.strategys;

import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class PercentStatus implements IPercentStatus{

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
        int numeroReclamacoesCategorias = buscaReclamacoesCategoriaPorStatus(reclamacoes, categoria).size();
        int totalReclamacoes = reclamacoes.size();

        return (double) (numeroReclamacoesCategorias * 100) / totalReclamacoes;
    }

    public double calculaPercentBairro(List<Reclamacao> reclamacoes, String bairro) {
        int numeroReclamacoesBairros = buscaReclamacoesBairroPorStatus(reclamacoes, bairro).size();
        int totalReclamacoes = reclamacoes.size();

        return (double) (numeroReclamacoesBairros * 100) / totalReclamacoes;
    }

    public List<Reclamacao> buscaReclamacoesCategoriaPorStatus(List<Reclamacao> reclamacoes, String categoria) {
        List<Reclamacao> buscastatus = buscaReclamacoesPorCategorias(reclamacoes, categoria);

        return buscastatus
                .stream()
                .filter(e -> e.getStatus().toLowerCase().equals("encerrada") || e.getStatus().toLowerCase().equals("resolvida"))
                .collect(Collectors.toList());
    }

    public List<Reclamacao> buscaReclamacoesBairroPorStatus(List<Reclamacao> reclamacoes, String bairro) {
        List<Reclamacao> buscastatus = buscaReclamacoesPorBairros(reclamacoes, bairro);

        return buscastatus
                .stream()
                .filter(e -> e.getStatus().toLowerCase().equals("encerrada") || e.getStatus().toLowerCase().equals("resolvida"))
                .collect(Collectors.toList());
    }


    public List<Reclamacao> buscaReclamacoesPorCategorias(List<Reclamacao> reclamacoes, String categoria) {

        return reclamacoes
                .stream()
                .filter(e -> e.getCategoria().toLowerCase().equals(categoria.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Reclamacao> buscaReclamacoesPorBairros(List<Reclamacao> reclamacoes, String bairro) {
        return reclamacoes
                .stream()
                .filter(e -> e.getBairro().toLowerCase().equals(bairro.toLowerCase()))
                .collect(Collectors.toList());
    }

}
