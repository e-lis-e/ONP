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
@Table(name = "discussao")
public class Discussao {
    //TODO: EXCLUIR ENTIDADE E PASSAR LÓGICA PARA POSTAGEM

    @Id
    @GeneratedValue
    private Long discursao_id;
    private String titulo;
    private String conteudo;
    private String interacao;
    @OneToMany(mappedBy = "discussao")
    private List<Comentario> comentarios;
    private Date data;
}
