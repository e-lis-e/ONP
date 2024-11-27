package br.com.politics.ONP.exceptions;

import br.com.politics.ONP.exceptions.usuario.UsuarioExistenteException;
import br.com.politics.ONP.exceptions.usuario.UsuarioNaoEncontradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<String> handleUsuarioNaoEncontradoException(UsuarioNaoEncontradoException ex) {
        return ResponseEntity.status(404).body("Usuário não encontrado: " + ex.getMessage());
    }

    @ExceptionHandler(UsuarioExistenteException.class)
    public ResponseEntity<String> handleUsuarioExistenteException(UsuarioExistenteException ex) {
        return ResponseEntity.status(500).body(ex.getMessage());
    }
}
