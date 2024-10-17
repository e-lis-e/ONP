package br.com.politics.ONP.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.politics.ONP.entities.Postagem;
import br.com.politics.ONP.entities.Usuario;
import br.com.politics.ONP.services.postagem.PostagemService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@Controller
@ResponseBody
public class PostagemController {

  @Autowired
  private PostagemService postagemService;

  @GetMapping
  public List<Postagem> getAllPostagens() {
    return postagemService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Postagem> getPostagemById(@PathVariable Long id) {
    Optional<Postagem> postagem = postagemService.findById(id);
    return postagem.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping("/usuario/{usuario_Id}")
  public ResponseEntity<List<Postagem>> findByUsuario(@PathVariable Long usuario_id) {
    Usuario usuario = new Usuario();
    usuario.setId(usuario_id);
    List<Postagem> postagens = postagemService.findByUsuario(usuario_id); //FIXME: esta recebendo o usuário ID, porém a função pede um Usuário Object
    return ResponseEntity.ok(postagens);
  }

  @PostMapping
  public ResponseEntity<Postagem> createPostagem(@RequestBody Postagem postagem) {
    return ResponseEntity.ok(postagemService.save(postagem));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Postagem> updatePostagem(@PathVariable Long id, @RequestBody Postagem postagemDetails) {
    return ResponseEntity.ok(postagemService.update(id, postagemDetails));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePostagem(@PathVariable Long id) {
    postagemService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
