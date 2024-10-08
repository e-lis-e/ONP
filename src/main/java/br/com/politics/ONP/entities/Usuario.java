package br.com.politics.ONP.entities;

import br.com.politics.ONP.entities.enums.PerfilEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String senha;
    private String fotoDePerfil;
    private String comentarios; //TODO: Adicionar relação.
    private String dicussaos; //TODO: Adicionar relação.
    @Enumerated(EnumType.STRING)
    private PerfilEnum tipoUsuario;
    private Postagem postagens; 
    private String curtidas; //TODO: Adicionar relação.

}
