package com.grupo2.TFCidaderaClone.aplication.useCases;

import com.grupo2.TFCidaderaClone.aplication.dtos.EstatisticaDTO;
import com.grupo2.TFCidaderaClone.aplication.services.ServicoEstatistica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuscaDados {
    
    private ServicoEstatistica servEstat;

    @Autowired
    public BuscaDados(ServicoEstatistica servEstat){
        this.servEstat = servEstat;
    }

    public EstatisticaDTO getEstatistica(int id, String filtro, String bairro, String categoria, int diaI, int mesI, int anoI, int diaF, int mesF, int anoF){
        return servEstat.calcEstatisticas(id, filtro, bairro, categoria, diaI, mesI, anoI, diaF, mesF, anoF);
    }

}
