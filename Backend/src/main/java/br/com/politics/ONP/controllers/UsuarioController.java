package br.com.politics.ONP.controllers;

import br.com.politics.ONP.entities.Usuario;
import br.com.politics.ONP.exceptions.UsuarioExistenteException;
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
        try {
            Usuario novoUsuario = usuarioService.cadastrarUsuario(usuario);
            return ResponseEntity.status(201).body(novoUsuario);
        } catch (UsuarioExistenteException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<Usuario> listaUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok((Usuario) usuarios);
    }

    //Método de tratamento de erro =! de try and catch
}
