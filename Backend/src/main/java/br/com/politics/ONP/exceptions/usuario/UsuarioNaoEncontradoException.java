package br.com.politics.ONP.exceptions.usuario;

public class UsuarioNaoEncontradoException extends RuntimeException {

    public UsuarioNaoEncontradoException(String message) {
        super("Usuário com e-mail " + message + " não encontrado.");
    }

    public UsuarioNaoEncontradoException() {
        super("ID inexistente");
    }
}
