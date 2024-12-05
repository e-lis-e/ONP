package br.com.politics.ONP.repositories;

import br.com.politics.ONP.entities.Interacao;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.politics.ONP.entities.Comentario;

import java.util.List;
import java.util.Optional;


public interface ComentarioRepository extends JpaRepository<Comentario, Long>{
    public List<Comentario> findByUsuarioId(Long usuario_id);
    public List<Comentario> findByPostagemId(Long postagem_id);
    public List<Comentario> findByComentarioPaiId(Long comentario_id);
    
}
