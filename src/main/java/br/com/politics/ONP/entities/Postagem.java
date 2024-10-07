package br.com.politics.ONP.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

//provisório
public class Postagem {
    @Id
    @GeneratedValue
    private Long id;
    private String usuario;
    private String titulo;
    private String conteudo;
    private Boolean curtida;
    private String comentario;
    
}
