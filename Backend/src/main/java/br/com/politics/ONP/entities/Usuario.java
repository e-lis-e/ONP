package br.com.politics.ONP.entities;

import br.com.politics.ONP.entities.enums.PerfilEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "usuarios")
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
    @Enumerated(EnumType.STRING)
    private PerfilEnum tipoUsuario;
    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference
    private List<Postagem> postagens;
    @OneToMany(mappedBy = "usuario")
    private List<Interacao> interacoes;

}
