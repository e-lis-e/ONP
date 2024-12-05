package br.com.politics.ONP.services.cometario;

import br.com.politics.ONP.entities.Comentario;

import java.util.List;

public interface ComentarioService {

    public Comentario createComentario(Comentario comentario);
    public Comentario updateComentario(Comentario comentario);
    public Comentario deleteComentario(Long comentario_id);
    public Comentario getComentario(Comentario comentario);
    public List<Comentario> getAllComentarios();

}
