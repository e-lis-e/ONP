package br.com.politics.ONP.controllers;

import java.util.List;
import java.util.Optional;

import br.com.politics.ONP.services.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import br.com.politics.ONP.entities.Postagem;
import br.com.politics.ONP.services.postagem.PostagemService;

@RestController
@Controller
@ResponseBody
@RequestMapping("/api/postagem")
public class PostagemController {

  @Autowired
  private PostagemService postagemService;

  @PostMapping
  public ResponseEntity<Postagem> createPostagem(@RequestBody Postagem postagem) {
    return ResponseEntity.ok(postagemService.createPostagem(postagem));
  }

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

  @GetMapping("/usuario/{usuario_id}")
  public ResponseEntity<List<Postagem>> findByUsuarioId(@PathVariable Long usuario_id) {
    List<Postagem> postagens = postagemService.findByUsuarioId(usuario_id);
    return ResponseEntity.ok(postagens);
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
