package br.com.politics.ONP.controllers;

import br.com.politics.ONP.entities.Comentario;
import br.com.politics.ONP.services.cometario.CometarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Controller
@ResponseBody
@RequestMapping("/api/comentarios")

public class ComentarioController {

    @Autowired
    private CometarioService comentarioService;

    @GetMapping("/discursao/{discursaoId}")
    public ResponseEntity<List<Comentario>> getComentariosByDiscursaoId(@PathVariable Long discursaoId) {
        List<Comentario> comentarios = comentarioService.findByDiscursaoId(discursaoId);
        return ResponseEntity.ok(comentarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comentario> getComentarioById(@PathVariable Long id) {
        Optional<Comentario> comentario = comentarioService.findById(id);
        return comentario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Comentario> createComentario(@RequestBody Comentario comentario) {
        return ResponseEntity.ok(comentarioService.save(comentario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comentario> updateComentario(@PathVariable Long id, @RequestBody Comentario comentarioDetails) {
        return ResponseEntity.ok(comentarioService.update(id, comentarioDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComentario(@PathVariable Long id) {
        comentarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
