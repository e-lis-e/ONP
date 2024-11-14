package br.com.politics.ONP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.politics.ONP.entities.Postagem;

import java.util.List;


public interface PostagemRepository extends JpaRepository<Postagem, Long>{
    List<Postagem> findByUsuarioId(Long usuario_id);
    // @Query()
    
}
