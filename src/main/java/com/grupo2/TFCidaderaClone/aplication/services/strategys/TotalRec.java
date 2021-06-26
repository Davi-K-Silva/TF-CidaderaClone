package com.grupo2.TFCidaderaClone.aplication.services.strategys;

import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;

import java.time.LocalDate;
import java.util.List;

public class TotalRec implements ITotalRec{

    @Override
    public int calcTotal(List<Reclamacao> reclamacoes,String filtro, String bairro, String categoria, LocalDate dataI, LocalDate dataF) {
        return 0;
    }
}
