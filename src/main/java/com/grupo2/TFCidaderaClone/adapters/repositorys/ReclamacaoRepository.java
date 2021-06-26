package com.grupo2.TFCidaderaClone.adapters.repositorys;

import java.util.List;

import com.grupo2.TFCidaderaClone.business.entities.Reclamacao;
import com.grupo2.TFCidaderaClone.business.entities.Usuario;
import com.grupo2.TFCidaderaClone.business.repositorys.IReclamacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReclamacaoRepository implements IReclamacaoRepository{
    private IReclamacaoCRUD reclamacaoCRUD;
    private IUsuarioCRUD usuarioCRUD;
    private IComentarioCRUD comentarioCRUD;

    @Autowired
    public ReclamacaoRepository(IReclamacaoCRUD reclamacaoCRUD, IUsuarioCRUD usuarioCRUD, IComentarioCRUD comentarioCRUD) {
        this.reclamacaoCRUD = reclamacaoCRUD;
        this.usuarioCRUD = usuarioCRUD;
        this.comentarioCRUD = comentarioCRUD;
    }

    public List<Reclamacao> todos() {
        return reclamacaoCRUD.findAll();
    }

    public boolean cadastra(int id, Reclamacao reclamacao) {
        Usuario usuario = usuarioCRUD.findById((Integer) id).get();
        if (usuario != null) {
            reclamacao.setUsuario(usuario);
            reclamacaoCRUD.save(reclamacao);
            return true;
        }
        return false;
    }

    public boolean atualiza(int id, Reclamacao reclamacao) {
        Usuario usuario = usuarioCRUD.findById((Integer) id).get();
        reclamacaoCRUD.deleteById(reclamacao.getId());
        if (usuario != null) {
            reclamacao.setUsuario(usuario);
            reclamacaoCRUD.save(reclamacao);
            return true;
        }
        return false;
    }

    public void removeTodos() {
        reclamacaoCRUD.deleteAll();
    }

}
