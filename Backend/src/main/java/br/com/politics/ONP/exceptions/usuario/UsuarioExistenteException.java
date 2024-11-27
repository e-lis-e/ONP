package br.com.politics.ONP.exceptions.usuario;

public class UsuarioExistenteException extends RuntimeException{
    public UsuarioExistenteException() {
        super("Um outro usuário com este e-mail já existe.");
    }

    public UsuarioExistenteException(String message, Throwable cause){
        super(message, cause);
    }
}
