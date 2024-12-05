package br.com.politics.ONP.entities;

import br.com.politics.ONP.entities.enums.PerfilEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario implements UserDetails {
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

    public Usuario(String nomeDeUsuario, String email, String senha, String fotoDePerfil) {
        this.nomeDeUsuario = nomeDeUsuario;
        this.email = email;
        this.senha = senha;
        this.fotoDePerfil = fotoDePerfil;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.tipoUsuario==PerfilEnum.ADMINISTRADOR){
            return List.of(new SimpleGrantedAuthority("ROLE_ADMINISTRADOR"),
                    new SimpleGrantedAuthority("ROLE_USUARIO"));
        }
        return List.of(new SimpleGrantedAuthority("ROLE_USUARIO"));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}
