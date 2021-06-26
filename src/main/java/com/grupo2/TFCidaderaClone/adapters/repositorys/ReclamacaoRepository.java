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

        Reclamacao reclamacao1 = new Reclamacao(1, "Muito buraco", "Não da pra voar com tanto buraco", "Bom jesus", ".......", "calçada", "Aberto", "via publica", "https:imgur.com/imagem.jpg", 15, 6, 2021);
        Reclamacao reclamacao2 = new Reclamacao(2, "Sinaleira estragada", "Tudo tranca nessa maldita sinaleira", "Bom Fim", ".......", "rua", "Aberto", "transito", "https:imgur.com/imagem2.jpg", 2, 7, 2021);
        Reclamacao reclamacao3 = new Reclamacao(3, "UMA BOMBA!", "Tem uma bomba instalada na lixeira!!", "Centro", "julho de castilhos", "calçada", "Aberto", "Segurança Publica", "https:imgur.com/bomb.jpg", 1, 7, 2021);

        cadastra(1, reclamacao1);
        cadastra(1, reclamacao2);
        cadastra(2, reclamacao3);
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
