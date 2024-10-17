package br.com.politics.ONP.controllers;

import br.com.politics.ONP.entities.Usuario;
import br.com.politics.ONP.exceptions.UsuarioExistenteException;
import br.com.politics.ONP.services.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    //Método de tratamento de erro =! de try and catch
}
