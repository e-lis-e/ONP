package br.com.politics.ONP.services.postagem;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;

import br.com.politics.ONP.entities.Postagem;
import br.com.politics.ONP.repositories.PostagemRepository;

@Service
public class PostagemService {

    @Autowired
    private PostagemRepository postagemRepository;

    public Postagem createPostagem(Postagem postagem) {
        return postagemRepository.save(postagem);
    }

    public List<Postagem> findAll() {
        return postagemRepository.findAll();
    }

    public Optional<Postagem> findById(Long postagem_id) {
        return postagemRepository.findById(postagem_id);
    }

    public List<Postagem> findByUsuarioId(Long usuario_id) {
        return postagemRepository.findByUsuarioId(usuario_id);
    }


    public Postagem update(Long postagem_id, Postagem postagemDetails) {
        Optional<Postagem> postagemExistente = postagemRepository.findById(postagem_id);

        if (postagemExistente.isPresent()) {
            Postagem postagemAtual = postagemExistente.get();

            for (Field field : Postagem.class.getDeclaredFields()) {
                field.setAccessible(true);

                if (!field.getName().equals("id")) {
                    try {
                        Object novoValor = field.get(postagemDetails);
                        if (novoValor != null) {
                            field.set(postagemAtual, novoValor);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            return postagemRepository.save(postagemAtual);
        }
        throw new RuntimeException("Postagem não encontrada com o ID: " + postagem_id);
    }


    public void delete(Long postagem_id) {
        postagemRepository.deleteById(postagem_id);
    }
}
