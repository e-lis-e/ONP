package br.com.politics.ONP.services.usuario;

import br.com.politics.ONP.entities.Usuario;
import br.com.politics.ONP.exceptions.usuario.UsuarioExistenteException;
import br.com.politics.ONP.exceptions.usuario.UsuarioNaoEncontradoException;
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

        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente.isPresent()) {
            throw new UsuarioExistenteException();
        }

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario atualizarUsuario(Usuario usuario) throws UsuarioNaoEncontradoException {
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente.isPresent()) {
            usuario.setId(usuarioExistente.get().getId());
            return usuarioRepository.save(usuario);
        }

        throw new UsuarioNaoEncontradoException(usuarioExistente.get().getEmail());
    }

    @Override
    @Transactional
    public void removerUsuario(Long id) throws UsuarioNaoEncontradoException {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        usuarioExistente.ifPresent(usuario -> usuarioRepository.delete(usuario));
        throw new UsuarioNaoEncontradoException();
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarUsuarioPorEmail(String email) throws UsuarioNaoEncontradoException {
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(email);
        return usuarioExistente.orElseThrow(() -> new UsuarioNaoEncontradoException(email));
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id) throws UsuarioNaoEncontradoException {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        return usuarioExistente.orElseThrow(UsuarioNaoEncontradoException::new);
    }

}
