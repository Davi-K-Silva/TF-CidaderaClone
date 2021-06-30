package com.grupo2.TFCidaderaClone.aplication.services.strategys;

import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TotalRec implements ITotalRec{

    @Override
    public int calcTotal(List<Reclamacao> reclamacoes, String filtro, String bairro, String categoria, LocalDate dataI, LocalDate dataF) {
        int totalReclamacoes = 0;

        switch (filtro) {
            case "bairro":
                totalReclamacoes = buscaReclamacoesBairro(reclamacoes, bairro, dataI, dataF);
                break;

            case "categoria":
                totalReclamacoes = buscaReclamacoesCategoria(reclamacoes, categoria, dataI, dataF);
                break;

            case "periodo":
                totalReclamacoes = buscaReclamacoesNoPeriodo(reclamacoes, dataI, dataF).size();
        }

        return totalReclamacoes;
    }


    public int buscaReclamacoesCategoria(List<Reclamacao> reclamacoes, String categoria, LocalDate dataInicial, LocalDate dataFinal) {
        List<Reclamacao> reclamacoesPeriodo = buscaReclamacoesNoPeriodo(reclamacoes, dataInicial, dataFinal);
        return reclamacoesPeriodo
                .stream()
                .filter(e -> e.getCategoria().toLowerCase().equals(categoria.toLowerCase()))
                .collect(Collectors.toList()).size();
    }

    public int buscaReclamacoesBairro(List<Reclamacao> reclamacoes, String bairro, LocalDate dataInicial, LocalDate dataFinal) {
        List<Reclamacao> reclamacoesPeriodo = buscaReclamacoesNoPeriodo(reclamacoes, dataInicial, dataFinal);
        return reclamacoesPeriodo
                .stream()
                .filter(e -> e.getBairro().toLowerCase().equals(bairro.toLowerCase()))
                .collect(Collectors.toList()).size();
    }

    public List<Reclamacao> buscaReclamacoesNoPeriodo(List<Reclamacao> reclamacoes, LocalDate dataInicial, LocalDate dataFinal) {
        List<LocalDate> periodo = periodo(dataInicial, dataFinal);
        return reclamacoes
            .stream()
            .filter(e -> periodo.contains(e.getData()))
            .collect(Collectors.toList());
    }

    private List<LocalDate> periodo(LocalDate tempoInicial, LocalDate tempoFinal) {
        return tempoInicial.datesUntil(tempoFinal).collect(Collectors.toList());
    }
}
