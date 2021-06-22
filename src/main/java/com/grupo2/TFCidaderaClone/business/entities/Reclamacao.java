package com.grupo2.TFCidaderaClone.business.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "reclamacao")
public class Reclamacao {
    @Id
    int id;
    private String titulo;
    private String desc;
    private String bairro;
    private String endereco;
    private String localProblema;
    private String status;
    private String categoria;
    private String imagem;
    // Data da reclamacao
    private int dia;
    private int mes;
    private int ano;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public int getUsuarioId() {
        return usuario.getId();
    }

    @OneToMany(mappedBy = "reclamacao", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Comentario> comentarios = new ArrayList<>();

    public void addcomentario(Comentario comentario){
        comentarios.add(comentario);
        comentario.setReclamcao(this);
    }
 
    public void removecomentario(Comentario comentario) {
        comentarios.remove(comentario);
        comentario.setReclamcao(null);
    }

    public Reclamacao(int id, String titulo, String desc, String bairro, String endereco, String localProblema, String status, String categoria, String imagem, int dia, int mes, int ano) {
        this.id = id;
        this.titulo = titulo;
        this.desc = desc;
        this.bairro = bairro;
        this.endereco = endereco;
        this.localProblema = localProblema;
        this.status = status;
        this.categoria = categoria;
        this.imagem = imagem;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    protected Reclamacao() {}

    public int getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getBairro() {
        return this.bairro;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getLocalProblema() {
        return this.localProblema;
    }

    public String getStatus() {
        return this.status;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public String getImagem() {
        return this.imagem;
    }

    public int getDia() {
        return this.dia;
    }

    public int getMes() {
        return this.mes;
    }

    public int getAno() {
        return this.ano;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", titulo='" + getTitulo() + "'" +
            ", desc='" + getDesc() + "'" +
            ", bairro='" + getBairro() + "'" +
            ", endereco='" + getEndereco() + "'" +
            ", localProblema='" + getLocalProblema() + "'" +
            ", status='" + getStatus() + "'" +
            ", categoria='" + getCategoria() + "'" +
            ", imagem='" + getImagem() + "'" +
            ", dia='" + getDia() + "'" +
            ", mes='" + getMes() + "'" +
            ", ano='" + getAno() + "'" +
            "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Reclamacao)) return false;
        return id == (((Reclamacao) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


    
}
