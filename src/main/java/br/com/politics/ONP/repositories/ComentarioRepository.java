        package br.com.politics.ONP.repositories;

        import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

        import br.com.politics.ONP.entities.Comentario;

        public interface ComentarioRepository extends JpaRepository<Comentario, Long>{

            List<Comentario> findByDiscussaoId(Long discursaoId);
            
        }
