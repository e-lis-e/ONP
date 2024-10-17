package br.com.politics.ONP.services.usuario;

import br.com.politics.ONP.entities.Usuario;
import br.com.politics.ONP.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public Usuario cadastrarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public Usuario atualizarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public void removerUsuario(Usuario usuario) {

    }

    @Override
    public List<Usuario> listarUsuarios() {
        return List.of();
    }

    @Override
    public Usuario buscarUsuarioPorEmail(String email) {
        return null;
    }

    @Override
    public Usuario buscarUsuarioPorId(Integer id) {
        return null;
    }

    @Override
    public Usuario buscarUsuarioPorLoginESenha(String login, String senha) {
        return null;
    }
}
