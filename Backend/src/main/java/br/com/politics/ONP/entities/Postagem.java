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
@Table

public class Postagem {
    @Id
    @GeneratedValue
    private Long postagem_id;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private String titulo;
    private String conteudo;
    private String interacao; //TODO: relacionar à entidade
    @OneToMany(mappedBy = "postagem")
    private List<Comentario> comentarios;
    private Date data;

    //Adicionar tipo de postagem
    
}
