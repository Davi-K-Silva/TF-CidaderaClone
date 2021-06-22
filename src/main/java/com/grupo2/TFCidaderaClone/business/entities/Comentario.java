package com.grupo2.TFCidaderaClone.business.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "comentario")
public class Comentario {
    @Id
    int id;
    String corpoComentario;
    String imagem;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public int getUsuarioId() {
        return usuario.getId();
    }

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "reclamacao_id", nullable = false)
    private Reclamacao reclamacao;

    public void setReclamcao(Reclamacao reclamacao){
        this.reclamacao= reclamacao;
    }
    public int setReclamcao() {
        return reclamacao.getId();
    }

    public Comentario(int id, String corpoComentario, String imagem) {
        this.id = id;
        this.corpoComentario = corpoComentario;
        this.imagem = imagem;
    }

    public int getId() {
        return this.id;
    }

    public String getCorpoComentario() {
        return this.corpoComentario;
    }

    public String getImagem() {
        return this.imagem;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", corpoComentario='" + getCorpoComentario() + "'" +
            ", imagem='" + getImagem() +
            "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Comentario)) return false;
        return id == (((Comentario) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
