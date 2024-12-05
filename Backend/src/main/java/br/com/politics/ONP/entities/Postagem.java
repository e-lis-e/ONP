package br.com.politics.ONP.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "postagens")

public class Postagem {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private String titulo;
    private String conteudo;
    @OneToMany(mappedBy = "postagem")
    private List<Interacao> interacoes;
    @OneToMany(mappedBy = "postagem")
    private List<Comentario> comentarios;
    private Date data;
    private boolean postagemAdmin = false;
    
}
