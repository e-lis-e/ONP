package br.com.politics.ONP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.politics.ONP.entities.Discursao;

public interface DiscursaoRepository extends JpaRepository<Discursao, Long> {
}