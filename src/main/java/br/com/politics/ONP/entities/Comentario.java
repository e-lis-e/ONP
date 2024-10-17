package br.com.politics.ONP.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table

public class Comentario {
    @Id
    @GeneratedValue
    private Long comentario_id;

    @ManyToOne
    @JoinColumn(name = "postagem_id")
    private Postagem postagem;

    @ManyToOne
    @JoinColumn(name = "discussao_id")
    private Discursao discussao;

    private String conteudo;
    private String interacao; //TODO: relacionar à entidade
    
    @ManyToOne
    @JoinColumn(name = "comentario_pai_id")
    private Comentario comentarioPai;
    
    @OneToMany(mappedBy = "comentarioPai")
    private List<Comentario> comentarioFilho;
    
    private Data data;


    
}
