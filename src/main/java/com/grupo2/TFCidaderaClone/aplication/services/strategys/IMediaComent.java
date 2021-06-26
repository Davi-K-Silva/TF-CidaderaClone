package com.grupo2.TFCidaderaClone.aplication.services.strategys;

import com.grupo2.TFCidaderaClone.business.entities.Comentario;
import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;

import java.time.LocalDate;
import java.util.Map;

public interface IMediaComent {
    public double calcMedia(Map<Reclamacao, Comentario> comentariosReclamacoes, String bairro, LocalDate tempoInicial, LocalDate tempoFinal, String categoria, String filtro);

}
