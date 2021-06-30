package com.grupo2.TFCidaderaClone.aplication.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.grupo2.TFCidaderaClone.aplication.dtos.EstatisticaDTO;
import com.grupo2.TFCidaderaClone.aplication.services.strategys.IMediaComent;
import com.grupo2.TFCidaderaClone.aplication.services.strategys.IPercentRespostas;
import com.grupo2.TFCidaderaClone.aplication.services.strategys.IPercentStatus;
import com.grupo2.TFCidaderaClone.aplication.services.strategys.ITotalRec;
import com.grupo2.TFCidaderaClone.business.entities.Comentario;
import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;
import com.grupo2.TFCidaderaClone.business.services.ServicoComentario;
import com.grupo2.TFCidaderaClone.business.services.ServicoReclamacao;
import com.grupo2.TFCidaderaClone.business.services.validation.IValidaUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoEstatistica {
    ServicoReclamacao servicoReclamacao;
    ServicoComentario servicoComentario;
    IValidaUsuario iValidaUsuario;
    IPercentRespostas iPercentRespostas;
    IPercentStatus iPercentStatus;
    IMediaComent iMediaComent;
    ITotalRec iTotalRec;
    
    @Autowired
    public ServicoEstatistica(ServicoReclamacao servicoReclamacao, ServicoComentario servicoComentario, IValidaUsuario iValidaUsuario, IPercentRespostas iPercentRespostas, IPercentStatus iPercentStatus, IMediaComent iMediaComent, ITotalRec iTotalRec){
        this.servicoReclamacao = servicoReclamacao;
        this.servicoComentario = servicoComentario;
        this.iValidaUsuario = iValidaUsuario;
        this.iPercentRespostas = iPercentRespostas;
        this.iPercentStatus = iPercentStatus;
        this.iMediaComent = iMediaComent;
        this.iTotalRec = iTotalRec;
    }

    public EstatisticaDTO calcEstatisticas(int id, String filtro, String bairro, String categoria, int diaI, int mesI, int anoI, int diaF, int mesF, int anoF){
        if(iValidaUsuario.validaUsuario(id, "A")){
            List<Reclamacao> reclamacoes = servicoReclamacao.todasReclamacoes();
            Map<Reclamacao,List<Comentario>> reclamacoesCompleto = servicoReclamacao.todasReclamacoesCompleto();
            LocalDate dataI = LocalDate.of(anoI, mesI, diaI);
            LocalDate dataF = LocalDate.of(anoF, mesF, diaF);
             EstatisticaDTO resultDTO = new EstatisticaDTO(iPercentRespostas.calcPercentR(reclamacoes), iPercentStatus.calcPercentS(reclamacoes,filtro,bairro,categoria), iMediaComent.calcMedia(reclamacoesCompleto,bairro,dataI,dataF,categoria,filtro), iTotalRec.calcTotal(reclamacoes,filtro,bairro,categoria,dataI,dataF));
            return resultDTO;
        }   
            return new EstatisticaDTO(0.0,0.0,0.0,0);
    }
}
