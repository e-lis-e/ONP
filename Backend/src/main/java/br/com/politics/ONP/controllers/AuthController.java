package br.com.politics.ONP.controllers;

import br.com.politics.ONP.security.TokenService;
import br.com.politics.ONP.services.usuario.UsuarioService;
import br.com.politics.ONP.entities.DTO.LoginDTO;
import br.com.politics.ONP.entities.DTO.UsuarioDTO;
import br.com.politics.ONP.entities.Usuario;
import br.com.politics.ONP.entities.enums.PerfilEnum;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(
                loginDTO.email(), loginDTO.senha());

        var auth = this.authenticationManager.authenticate(usernamePassword);
        String token = tokenService.generateToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok().body(token);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO.nomeDeUsuario(),
                usuarioDTO.email(), usuarioDTO.senha(),
                usuarioDTO.fotoDePerfil());

        usuario.setTipoUsuario(PerfilEnum.USUARIO);

        usuario = usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/register/admin")
    public ResponseEntity registerAdmin(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO.nomeDeUsuario(),
                usuarioDTO.email(), usuarioDTO.senha(),
                usuarioDTO.fotoDePerfil());

        usuario.setTipoUsuario(PerfilEnum.ADMINISTRADOR);

        usuario = usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.ok(usuario);
    }


}
