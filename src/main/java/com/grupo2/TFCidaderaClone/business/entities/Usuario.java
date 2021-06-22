package com.grupo2.TFCidaderaClone.business.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "usuario")
public class Usuario {
    @Id
    private int id;
    String nome;
    String tipo;

    public Usuario(int id, String nome, String tipo){
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }
    
    protected Usuario() {}

    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public String getTipo(){
        return tipo;
    }

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Reclamacao> reclamacoes = new ArrayList<>();

    public void addreclamacao(Reclamacao reclamacao){
        reclamacoes.add(reclamacao);
        reclamacao.setUsuario(this);
    }
 
    public void removereclamacao(Reclamacao reclamacao) {
        reclamacoes.remove(reclamacao);
        reclamacao.setUsuario(null);
    }

    @OneToMany(mappedBy = "reclamacao", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Comentario> comentarios = new ArrayList<>();

    public void addcomentario(Comentario comentario){
        comentarios.add(comentario);
        comentario.setUsuario(this);
    }
 
    public void removecomentario(Comentario comentario) {
        comentarios.remove(comentario);
        comentario.setUsuario(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario )) return false;
        return id != 0 && id == ((Usuario) o).getId();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
