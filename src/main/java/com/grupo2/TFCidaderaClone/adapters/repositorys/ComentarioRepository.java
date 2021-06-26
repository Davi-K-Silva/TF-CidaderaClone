package com.grupo2.TFCidaderaClone.adapters.repositorys;

import java.util.List;

import com.grupo2.TFCidaderaClone.business.entities.Comentario;
import com.grupo2.TFCidaderaClone.business.repositorys.IComentarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComentarioRepository implements IComentarioRepository{
    IComentarioCRUD comentarioCRUD;
    IReclamacaoCRUD reclamacaoCRUD;

    @Autowired
    public ComentarioRepository(IComentarioCRUD comentarioCRUD, IReclamacaoCRUD reclamacaoCRUD) {
        this.comentarioCRUD = comentarioCRUD;
        this.reclamacaoCRUD = reclamacaoCRUD;
    }

    public List<Comentario> todos() {
        return comentarioCRUD.findAll();
    }

    public boolean cadastra(int id,Comentario comentario) {
        comentarioCRUD.save(comentario);
        return true;
    }

    public void removeTodos() {
        comentarioCRUD.deleteAll();
    }

}
