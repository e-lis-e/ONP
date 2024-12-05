package br.com.politics.ONP.services.interacao;

import br.com.politics.ONP.entities.Interacao;

import java.util.List;

public interface InteracaoService {

    public void interagir(Interacao interacao);
    public void alterarInteracao(Interacao interacao);
    public void excluirInteracao(Interacao interacao);
    public List<Interacao> buscarInteracoesDaPostagem(Long postagem_id);
    public List<Interacao> buscarInteracoesDoComentario(Long postagem_id);
    public List<Interacao> buscarInteracoesDoUsusario(Long usuario_id);
}
