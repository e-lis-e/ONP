package br.com.politics.ONP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.politics.ONP.entities.Discussao;

public interface DiscussaoRepository extends JpaRepository<Discussao, Long> {
}