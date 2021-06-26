package com.grupo2.TFCidaderaClone.adapters.repositorys;

import java.util.List;

import com.grupo2.TFCidaderaClone.business.entities.Comentario;
import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;
import com.grupo2.TFCidaderaClone.business.entities.Usuario;
import com.grupo2.TFCidaderaClone.business.repositorys.IComentarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComentarioRepository implements IComentarioRepository{
    private IComentarioCRUD comentarioCRUD;
    private IReclamacaoCRUD reclamacaoCRUD;
    private IUsuarioCRUD usuarioCRUD;

    @Autowired
    public ComentarioRepository(IComentarioCRUD comentarioCRUD, IReclamacaoCRUD reclamacaoCRUD, IUsuarioCRUD usuarioCRUD) {
        this.comentarioCRUD = comentarioCRUD;
        this.reclamacaoCRUD = reclamacaoCRUD;
        this.usuarioCRUD = usuarioCRUD;
    }

    public List<Comentario> todos() {
        return comentarioCRUD.findAll();
    }

    public boolean cadastra(int idUs, int idRec,Comentario comentario) {
        Usuario usuario = usuarioCRUD.findById((Integer) idUs).get();
        Reclamacao reclamacao = reclamacaoCRUD.findById((Integer) idRec).get();
        if (usuario != null) {
            comentario.setUsuario(usuario);
            comentario.setReclamcao(reclamacao);
            comentarioCRUD.save(comentario);
            return true;
        }
        return false;
    }

    public void removeTodos() {
        comentarioCRUD.deleteAll();
    }

}
