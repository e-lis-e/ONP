package br.com.politics.ONP.repositories;

import br.com.politics.ONP.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
