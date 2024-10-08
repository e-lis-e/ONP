package br.com.politics.ONP.entities.enums;

public enum PerfilEnum {
    ADMINISTRADOR("Administrador"),
    USUARIO("Usuario"),;

    private final String nomePerfil;

    PerfilEnum(String nomePerfil) {
        this.nomePerfil = nomePerfil;
    }

    public String getNomePerfil() {
        return nomePerfil;
    }

}
