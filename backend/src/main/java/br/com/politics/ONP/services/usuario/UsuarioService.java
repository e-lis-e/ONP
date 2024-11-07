package br.com.politics.ONP.services.usuario;

import br.com.politics.ONP.entities.Usuario;
import br.com.politics.ONP.exceptions.UsuarioExistenteException;

import java.util.List;

public interface UsuarioService {

    public Usuario cadastrarUsuario(Usuario usuario) throws UsuarioExistenteException;
    public Usuario atualizarUsuario(Usuario usuario);
    public void removerUsuario(Long id);
    public List<Usuario> listarUsuarios();
    public Usuario buscarUsuarioPorEmail(String email);
    public Usuario buscarUsuarioPorId(Long id);
    public Usuario buscarUsuarioPorLoginESenha(String login, String senha);
}
