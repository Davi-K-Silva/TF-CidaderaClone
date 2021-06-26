package com.grupo2.TFCidaderaClone.aplication.services.strategys;

import com.grupo2.TFCidaderaClone.business.entities.Comentario;
import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MediaComent implements IMediaComent {


    @Override
    public double calcMedia(Map<Reclamacao, List<Comentario>> comentariosReclamacoes, String bairro, LocalDate dataInicial, LocalDate dataFinal, String categoria, String filtro) {
        double media = 0.0;
        switch (filtro) {
            case "categoria":
                media = totalComentariosCategoria(comentariosReclamacoes, filtro) / filtraCategoria(comentariosReclamacoes, categoria).size();
            break;
            case "bairro":
                media = totalComentariosBairro(comentariosReclamacoes, filtro) / filtraBairro(comentariosReclamacoes, bairro).size();
            break;
            case "periodo":
                media = totalComentariosPeriodo(comentariosReclamacoes, dataInicial, dataFinal) / filtraPeriodo(comentariosReclamacoes, dataInicial, dataFinal).size();
            break;
        }
        return media;
    }



    private int totalComentariosCategoria(Map<Reclamacao, List<Comentario>> comentariosReclamacoes, String categoria) {
        List<Comentario> comentarios = null;

        for (int i = 0; i < comentariosReclamacoes.size(); i++) {
            comentarios.add(comentariosReclamacoes.get(filtraCategoria(comentariosReclamacoes, categoria).get(i)).get(i));
        }
        int totalComentarios = comentarios.size();
        return totalComentarios;
    }

    private int totalComentariosBairro(Map<Reclamacao, List <Comentario>> comentariosReclamacoes, String bairro) {
        List<Comentario> comentarios = null;

        for (int i = 0; i < comentariosReclamacoes.size(); i++) {
            comentarios.add(comentariosReclamacoes.get(filtraBairro(comentariosReclamacoes, bairro).get(i)).get(i));
        }
        int totalComentarios = comentarios.size();
        return totalComentarios;
    }

    private int totalComentariosPeriodo(Map<Reclamacao, List <Comentario>> comentariosReclamacoes, LocalDate tempoInicial, LocalDate tempoFinal) {
        List<Comentario> comentarios = null;

        for (int i = 0; i < comentariosReclamacoes.size(); i++) {
            comentarios.add(comentariosReclamacoes.get(filtraPeriodo(comentariosReclamacoes, tempoInicial, tempoFinal).get(i)).get(i));
        }
        int totalComentarios = comentarios.size();
        return totalComentarios;
    }


    private List<Reclamacao> filtraCategoria(Map<Reclamacao, List <Comentario>> comentariosReclamacoes, String categoria) {
        return comentariosReclamacoes.keySet()
                .stream()
                .filter(e -> e.getCategoria() == categoria)
                .collect(Collectors.toList());
    }

    private List<Reclamacao> filtraBairro(Map<Reclamacao, List <Comentario>> comentariosReclamacoes, String bairro) {
        return comentariosReclamacoes.keySet()
                .stream()
                .filter(e -> e.getBairro() == bairro)
                .collect(Collectors.toList());
    }

    private List<Reclamacao> filtraPeriodo(Map<Reclamacao, List <Comentario>> comentariosReclamacoes, LocalDate dataInicial, LocalDate dataFinal) {
        List<LocalDate> periodo = periodo(dataInicial, dataFinal);
        return comentariosReclamacoes.keySet()
                .stream()
                .filter(e -> e.getData().equals(periodo) )
                .collect(Collectors.toList());
    }

    private List<LocalDate> periodo(LocalDate tempoInicial, LocalDate tempoFinal) {
        return tempoInicial.datesUntil(tempoFinal).collect(Collectors.toList());
    }


}
