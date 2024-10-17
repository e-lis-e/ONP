package br.com.politics.ONP.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "discussao")
public class Discussao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String conteudo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario autor;

    @OneToMany(mappedBy = "discussao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios;

    private Date dataCriacao;
}
