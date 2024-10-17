package br.com.politics.ONP.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comentarios")

public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long comentario_id;
    @ManyToOne
    @JoinColumn(name = "postagem_id")
    private Postagem postagem;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private String discussao; //TODO: relacionar à entidade
    private String conteudo;
    private String interacao; //TODO: relacionar à entidade
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "comentario_pai_id")
    private Comentario comentarioPai;
    @OneToMany(mappedBy = "comentarioPai", cascade = CascadeType.ALL)
    private List<Comentario> comentarioFilho;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;


    
}
