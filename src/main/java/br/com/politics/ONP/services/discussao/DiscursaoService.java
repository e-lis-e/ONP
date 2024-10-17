package br.com.politics.ONP.services.discussao;

import br.com.politics.ONP.entities.Discursao;
import br.com.politics.ONP.repositories.DiscursaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DiscursaoService {

    @Autowired
    private DiscursaoRepository discursaoRepository;

    public List<Discursao> findAll() {
        return discursaoRepository.findAll();
    }

    public Optional<Discursao> findById(Long id) {
        return discursaoRepository.findById(id);
    }

    public Discursao save(Discursao discursao) {
        return discursaoRepository.save(discursao);
    }

    public Discursao update(Long id, Discursao updatedDiscursao) {
        return discursaoRepository.findById(id)
                .map(discursao -> {
                    discursao.setTitulo(updatedDiscursao.getTitulo());
                    discursao.setConteudo(updatedDiscursao.getConteudo());
                    discursao.setAutor(updatedDiscursao.getAutor());
                    return discursaoRepository.save(discursao);
                })
                .orElseThrow(() -> new RuntimeException("Discussão não encontrada com o ID: " + id));
    }

    public void delete(Long id) {
        discursaoRepository.deleteById(id);
    }

}
