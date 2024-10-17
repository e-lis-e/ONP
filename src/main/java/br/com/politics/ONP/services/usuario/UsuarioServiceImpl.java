package br.com.politics.ONP.services.usuario;

import br.com.politics.ONP.entities.Usuario;
import br.com.politics.ONP.exceptions.UsuarioExistenteException;
import br.com.politics.ONP.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public Usuario cadastrarUsuario(Usuario usuario) throws UsuarioExistenteException {

        Optional<Usuario> usuariobanco = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuariobanco.isPresent()) {
            throw new UsuarioExistenteException();
        }

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario atualizarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public void removerUsuario(Long id) {
        Optional<Usuario> usuariobanco = usuarioRepository.findById(id);
        usuarioRepository.delete(usuariobanco.get());
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email).get();
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).get();
    }

    @Override
    public Usuario buscarUsuarioPorLoginESenha(String login, String senha) {
        return null;
    }
}
