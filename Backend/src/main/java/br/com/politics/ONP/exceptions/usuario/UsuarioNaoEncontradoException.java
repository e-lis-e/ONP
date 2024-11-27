package br.com.politics.ONP.exceptions.usuario;

public class UsuarioNaoEncontradoException extends RuntimeException {

    public UsuarioNaoEncontradoException(String message) {
        super("Usuário com e-mail " + message + " não encontrado.");
    }

    public UsuarioNaoEncontradoException(Throwable cause) {
        super("Usuário não encotrado.", cause);
    }
    public UsuarioNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }
    public UsuarioNaoEncontradoException() {
        super("ID inexistente");
    }
}
