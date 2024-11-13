package br.com.politics.ONP.entities;

import br.com.politics.ONP.entities.enums.PerfilEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    private String nomeDeUsuario;
    private String email;
    private String senha;
    private String fotoDePerfil;
    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;
    //@OneToMany(mappedBy = "usuario") TODO:Aguardando implementação de discussao
    //private List<Discussao> dicussaos;
    @Enumerated(EnumType.STRING)
    private PerfilEnum tipoUsuario;
    @OneToMany(mappedBy = "usuario")
    private List<Postagem> postagens;
    private String interacoes; //TODO: Adicionar relação.

}
