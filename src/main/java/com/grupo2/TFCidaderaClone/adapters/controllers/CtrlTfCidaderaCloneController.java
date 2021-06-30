package com.grupo2.TFCidaderaClone.adapters.controllers;

import java.util.List;
import java.util.Map;

import com.grupo2.TFCidaderaClone.aplication.dtos.EstatisticaDTO;
import com.grupo2.TFCidaderaClone.aplication.useCases.AtualizaReclamacao;
import com.grupo2.TFCidaderaClone.aplication.useCases.BuscaDados;
import com.grupo2.TFCidaderaClone.aplication.useCases.CadastraComentario;
import com.grupo2.TFCidaderaClone.aplication.useCases.CadastraUsuario;
import com.grupo2.TFCidaderaClone.aplication.useCases.CadastroReclamacoes;
import com.grupo2.TFCidaderaClone.aplication.useCases.ConsultaComentarios;
import com.grupo2.TFCidaderaClone.aplication.useCases.ConsultaReclamacao;
import com.grupo2.TFCidaderaClone.aplication.useCases.ConsultaReclamacoes;
import com.grupo2.TFCidaderaClone.aplication.useCases.ConsultaReclamacoesCompleto;
import com.grupo2.TFCidaderaClone.business.entities.Comentario;
import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;
import com.grupo2.TFCidaderaClone.business.entities.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ctrlCidaderaClone")
public class CtrlTfCidaderaCloneController {
    private BuscaDados buscaDados;
    private AtualizaReclamacao atualizaReclamacao;
    private CadastraComentario cadastraComentario;
    private CadastraUsuario cadastraUsuario;
    private CadastroReclamacoes cadastroReclamacoes;
    private ConsultaComentarios consultaComentarios;
    private ConsultaReclamacao consultaReclamacao;
    private ConsultaReclamacoes consultaReclamacoes;
    private ConsultaReclamacoesCompleto consultaReclamacoesCompleto;

    @Autowired
    public CtrlTfCidaderaCloneController(BuscaDados buscaDados, AtualizaReclamacao atualizaReclamacao, CadastraComentario cadastraComentario, CadastraUsuario cadastraUsuario, CadastroReclamacoes cadastroReclamacoes, ConsultaComentarios consultaComentarios, ConsultaReclamacao consultaReclamacao, ConsultaReclamacoes consultaReclamacoes, ConsultaReclamacoesCompleto consultaReclamacoesCompleto) {
        this.buscaDados = buscaDados;
        this.atualizaReclamacao = atualizaReclamacao;
        this.cadastraComentario = cadastraComentario;
        this.cadastraUsuario = cadastraUsuario;
        this.cadastroReclamacoes = cadastroReclamacoes;
        this.consultaComentarios = consultaComentarios;
        this.consultaReclamacao = consultaReclamacao;
        this.consultaReclamacoes = consultaReclamacoes;
        this.consultaReclamacoesCompleto = consultaReclamacoesCompleto;
    }

    @GetMapping("/reclamacoes")
    @CrossOrigin(origins = "*")
    public List<Reclamacao> consultaReclamacoes() {
        return consultaReclamacoes.todasReclamacoes();
    }

    @GetMapping("/reclamacao")
    @CrossOrigin(origins = "*")
    public Map<Reclamacao,List<Comentario>> consultaReclamacao(@RequestParam final Integer id) {
        return consultaReclamacao.getReclamacao(id);
    }

    @GetMapping("/reclamacoesCompleto")
    @CrossOrigin(origins = "*")
    public Map<Reclamacao,List<Comentario>> consultaReclamacoesCompleto(){
        return consultaReclamacoesCompleto.todasReclamacoesCompleto();
    }

    @PostMapping("/reclamacao") 
    @CrossOrigin(origins = "*")
    public boolean cadastraReclamacao(@RequestBody final Reclamacao reclamacao,@RequestParam final int id) {
        return cadastroReclamacoes.cadastra(reclamacao, id);
    }

    @PostMapping("/atReclamacao") 
    @CrossOrigin(origins = "*")
    public boolean atualizaReclamacao(@RequestBody final Reclamacao reclamacao,@RequestParam final int id) {
        return atualizaReclamacao.atualizar(reclamacao, id);
    }

    @GetMapping("/comentarios")
    @CrossOrigin(origins = "*")
    public List<Comentario> consultaComentarios() {
        return consultaComentarios.todosComentario();
    }

    @PostMapping("/comentario") 
    @CrossOrigin(origins = "*")
    public boolean cadastraComentario(@RequestBody final Comentario comentario, @RequestParam final int idUs, @RequestParam final int idRec) {
        return cadastraComentario.cadastra(idUs, idRec, comentario);
    }

    @PostMapping("/usuario") 
    @CrossOrigin(origins = "*")
    public boolean cadastraUsuario(@RequestBody final Usuario usuario, @RequestParam final int idUs) {
        return cadastraUsuario.cadastra(usuario,idUs);
    }

    @GetMapping("/dados")
    @CrossOrigin(origins = "*")
    public EstatisticaDTO consultaDados(@RequestParam final int id, @RequestParam final String filtro, @RequestParam final String bairro, @RequestParam final String categoria,
                                         @RequestParam final int diaI, @RequestParam final int mesI, @RequestParam final int anoI,
                                         @RequestParam final int diaF, @RequestParam final int mesF, @RequestParam final int anoF) { // DTO
        return buscaDados.getEstatistica(id, filtro, bairro, categoria, diaI, mesI, anoI, diaF, mesF, anoF);
    }

    @GetMapping("/cadastraInicial")
    @CrossOrigin(origins = "*")
    public boolean cadastroInicial() {
        return cadastraUsuario.cadastraInicial() && cadastroReclamacoes.cadastraInicial() && cadastraComentario.cadastraInicial();
    }

}
