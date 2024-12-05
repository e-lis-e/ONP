package br.com.politics.ONP.repositories;

import br.com.politics.ONP.entities.Interacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InteracaoRepository extends JpaRepository<Interacao, Long> {
    public Optional<Interacao> findByUsuarioId(Long usuario_id);
    public Optional<Interacao> findByComentarioId(Long comentario_id);
    public Optional<Interacao> findByPostagemId(Long postagem_id);
}
