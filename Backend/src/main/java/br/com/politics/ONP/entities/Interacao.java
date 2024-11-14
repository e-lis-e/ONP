package br.com.politics.ONP.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "interacoes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Interacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean like;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "postagem_id")
    private Postagem postagem;
    @ManyToOne
    @JoinColumn(name = "comentario_id")
    private Comentario comentario;
}
