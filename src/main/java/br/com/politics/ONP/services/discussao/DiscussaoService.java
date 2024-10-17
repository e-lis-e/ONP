package br.com.politics.ONP.services.discussao;

import br.com.politics.ONP.entities.Discussao;
import br.com.politics.ONP.repositories.DiscussaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscussaoService {

    @Autowired
    private DiscussaoRepository discussaoRepository; // Corrigido para manter a consistência

    public Optional<Discussao> findById(Long id) {
        return discussaoRepository.findById(id);
    }

    public Discussao save(Discussao discussao) {
        return discussaoRepository.save(discussao);
    }

    public Discussao update(Long id, Discussao updatedDiscussao) {
        return discussaoRepository.findById(id)
                .map(discussao -> {
                    discussao.setTitulo(updatedDiscussao.getTitulo());
                    discussao.setConteudo(updatedDiscussao.getConteudo());
                    return discussaoRepository.save(discussao);
                })
                .orElseThrow(() -> new RuntimeException("Discussão não encontrada com o ID: " + id));
    }

    public void delete(Long id) {
        discussaoRepository.deleteById(id);
    }
}
