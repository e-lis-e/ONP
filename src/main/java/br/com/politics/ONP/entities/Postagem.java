package br.com.politics.ONP.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    private String usuario; //TODO: relacionar à entidade
    private String titulo;
    private String conteudo;
    private String interacao; //TODO: relacionar à entidade
    @OneToMany(mappedBy = "comentario")
    private List<Comentario> comentarios; // ligado à entidade comentário
    private Date data;
    
}
