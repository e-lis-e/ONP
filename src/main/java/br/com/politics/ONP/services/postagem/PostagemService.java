package br.com.politics.ONP.services.postagem;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.politics.ONP.entities.Postagem;
import br.com.politics.ONP.entities.Usuario;
import br.com.politics.ONP.repositories.PostagemRepository;

@Service
public class PostagemService {

    @Autowired
    private PostagemRepository postagemRepository;

    public List<Postagem> findAll() {
        return postagemRepository.findAll();
    }

    public Optional<Postagem> findById(Long postagem_id) {
        return postagemRepository.findById(postagem_id);
    }

    public List<Postagem> findByUsuario(Long usuario_id) {
        return postagemRepository.findByUsuario(usuario_id);
    }

    public Postagem save(Postagem postagem) {
        return postagemRepository.save(postagem);
    }

    public Postagem update(Long postagem_id, Postagem postagemDetails) {
        return postagemRepository.findById(postagem_id).map(postagem -> {
            postagem.setTitulo(postagemDetails.getTitulo());
            postagem.setConteudo(postagemDetails.getConteudo());
            return postagemRepository.save(postagem);
        }).orElseThrow(() -> new RuntimeException("Postagem não encontrada com o ID: " + postagem_id));
    }

    public void delete(Long postagem_id) {
        postagemRepository.deleteById(postagem_id);
    }
}
