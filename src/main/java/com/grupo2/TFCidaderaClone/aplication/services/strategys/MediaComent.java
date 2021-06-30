package com.grupo2.TFCidaderaClone.aplication.services.strategys;

import com.grupo2.TFCidaderaClone.business.entities.Comentario;
import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class MediaComent implements IMediaComent {


    @Override
    public double calcMedia(Map<Reclamacao, List<Comentario>> comentariosReclamacoes, String bairro, LocalDate dataInicial, LocalDate dataFinal, String categoria, String filtro) {
        double media = 0.0;
        switch (filtro) {
            case "categoria":
                media = (double) totalComentariosCategoria(comentariosReclamacoes, categoria) / (double) filtraCategoria(comentariosReclamacoes, categoria).size();
                break;
            case "bairro":
                media = (double) totalComentariosBairro(comentariosReclamacoes, bairro) /  (double) filtraBairro(comentariosReclamacoes, bairro).size();
                break;
            case "periodo":
                media = (double) totalComentariosPeriodo(comentariosReclamacoes, dataInicial, dataFinal) / (double) filtraPeriodo(comentariosReclamacoes, dataInicial, dataFinal).size();
                break;
        }
        return media;
    }


    private int totalComentariosCategoria(Map<Reclamacao, List<Comentario>> comentariosReclamacoes, String categoria) {
        int totalComentarios = 0;
        List<Reclamacao> reclamacoes = new ArrayList<Reclamacao>();

        reclamacoes = filtraCategoria(comentariosReclamacoes, categoria);
        
        for(Reclamacao rec : reclamacoes){
            totalComentarios += comentariosReclamacoes.get(rec).size();  
        }

        return totalComentarios;
    }

    private int totalComentariosBairro(Map<Reclamacao, List<Comentario>> comentariosReclamacoes, String bairro) {
        int totalComentarios = 0;
        List<Reclamacao> reclamacoes = new ArrayList<Reclamacao>();

        reclamacoes = filtraBairro(comentariosReclamacoes, bairro);

        for(Reclamacao rec : reclamacoes){
            totalComentarios += comentariosReclamacoes.get(rec).size();  
        }

        return totalComentarios;
    }

    private int totalComentariosPeriodo(Map<Reclamacao, List<Comentario>> comentariosReclamacoes, LocalDate
            tempoInicial, LocalDate tempoFinal) {
        int totalComentarios = 0;
        List<Reclamacao> reclamacoes = new ArrayList<Reclamacao>();

        reclamacoes = filtraPeriodo(comentariosReclamacoes, tempoInicial, tempoFinal);

        for(Reclamacao rec : reclamacoes){
            totalComentarios += comentariosReclamacoes.get(rec).size();  
        }            
    
        return totalComentarios;
    }


    private List<Reclamacao> filtraCategoria(Map<Reclamacao, List<Comentario>> comentariosReclamacoes, String
            categoria) {
        return comentariosReclamacoes.keySet()
                .stream()
                .filter(reclamacao -> reclamacao.getCategoria().toLowerCase().equals(categoria.toLowerCase()))
                .collect(Collectors.toList());
    }

    private List<Reclamacao> filtraBairro(Map<Reclamacao, List<Comentario>> comentariosReclamacoes, String
            bairro) {
        return comentariosReclamacoes.keySet()
                .stream()
                .filter(e -> e.getBairro().toLowerCase().equals(bairro.toLowerCase()))
                .collect(Collectors.toList());
    }

    private List<Reclamacao> filtraPeriodo(Map<Reclamacao, List<Comentario>> comentariosReclamacoes, LocalDate
            dataInicial, LocalDate dataFinal) {
        List<LocalDate> periodo = periodo(dataInicial, dataFinal);
        return comentariosReclamacoes.keySet()
                .stream()
                .filter(e -> periodo.contains(e.getData()))
                .collect(Collectors.toList());
    }

    private List<LocalDate> periodo(LocalDate tempoInicial, LocalDate tempoFinal) {
        return tempoInicial.datesUntil(tempoFinal).collect(Collectors.toList());
    }


}
