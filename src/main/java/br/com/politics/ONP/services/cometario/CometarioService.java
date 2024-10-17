package br.com.politics.ONP.services.cometario;

import br.com.politics.ONP.entities.Comentario;
import br.com.politics.ONP.repositories.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CometarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<Comentario> findByDiscursaoId(Long discursaoId) {
        return comentarioRepository.findByDiscussaoId(discursaoId);
    }

    public Optional<Comentario> findById(Long id) {
        return comentarioRepository.findById(id);
    }

    public Comentario save(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public Comentario update(Long id, Comentario updatedComentario) {
        return comentarioRepository.findById(id)
                .map(comentario -> {
                    comentario.setConteudo(updatedComentario.getConteudo());
                    return comentarioRepository.save(comentario);
                })
                .orElseThrow(() -> new RuntimeException("Comentário não encontrado com o ID: " + id));
    }

    public void delete(Long id) {
        comentarioRepository.deleteById(id);
    }

}
