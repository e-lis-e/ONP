package br.com.politics.ONP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.politics.ONP.entities.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long>{
    
}
