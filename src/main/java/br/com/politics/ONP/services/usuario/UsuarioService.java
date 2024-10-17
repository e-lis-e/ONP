package br.com.politics.ONP.services.usuario;

import br.com.politics.ONP.entities.Usuario;

import java.util.List;

public interface UsuarioService {

    public Usuario cadastrarUsuario(Usuario usuario);
    public Usuario atualizarUsuario(Usuario usuario);
    public void removerUsuario(Usuario usuario);
    public List<Usuario> listarUsuarios();
    public Usuario buscarUsuarioPorEmail(String email);
    public Usuario buscarUsuarioPorId(Integer id);
    public Usuario buscarUsuarioPorLoginESenha(String login, String senha);
}
