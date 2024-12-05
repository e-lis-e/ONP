package br.com.politics.ONP.controllers;

import br.com.politics.ONP.entities.Usuario;
import br.com.politics.ONP.services.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> cadastraUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.status(201).body(novoUsuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listaUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/update")
    public ResponseEntity<Usuario> atualizarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioExistente = usuarioService.atualizarUsuario(usuario);
        return ResponseEntity.ok(usuarioExistente);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> removerUsuario(@PathVariable Long userId) {
        usuarioService.removerUsuario(userId);
        return ResponseEntity.noContent().build();
    }
    //buscarUsuarioPorEmail
    //buscarUsuarioPorId
}
