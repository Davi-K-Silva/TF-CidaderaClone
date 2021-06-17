package com.grupo2.TFCidaderaClone.adapters.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ctrlCidaderaClone")
public class CtrlTfCidaderaCloneController {
    
    @Autowired
    public CtrlTfCidaderaCloneController(){

    }

    @GetMapping("/reclamacoes")
    @CrossOrigin(origins = "*")
    public List<String> consultaReclamacoes() {
        return null;
    }

    @GetMapping("/reclamacao")
    @CrossOrigin(origins = "*")
    public List<String> consultaReclamaco() {
        return null;
    }

    @GetMapping("/reclamacoesCompleto")
    @CrossOrigin(origins = "*")
    public List<String> consultaCorredor() {
        return null;
    }

    @PostMapping("/reclamacao") 
    @CrossOrigin(origins = "*")
    public boolean cadastraReclamacao(@RequestBody final String placeholder) {
        return true;
    }

    @PostMapping("/aTTreclamacao") 
    @CrossOrigin(origins = "*")
    public boolean atualizaReclamacao(@RequestBody final String placeholder) {
        return true;
    }

    @GetMapping("/comentarios")
    @CrossOrigin(origins = "*")
    public List<String> consultaComentarios() {
        return null;
    }

    @PostMapping("/comentarios") 
    @CrossOrigin(origins = "*")
    public boolean cadastraComentario(@RequestBody final String placeholder) {
        return true;
    }

    @PostMapping("/usuario") 
    @CrossOrigin(origins = "*")
    public boolean cadastraUsuario(@RequestBody final String placeholder) {
        return true;
    }

    @GetMapping("/dados")
    @CrossOrigin(origins = "*")
    public List<String> consultaDados() { // DTO
        return null;
    }

}
