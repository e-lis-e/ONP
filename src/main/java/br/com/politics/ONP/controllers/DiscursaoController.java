package br.com.politics.ONP.controllers;

import br.com.politics.ONP.entities.Discursao;
import br.com.politics.ONP.services.discussao.DiscursaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Controller
@ResponseBody
@RequestMapping("/api/discussoes")

public class DiscursaoController {


    @Autowired
    private DiscursaoService discursaoService;

    @GetMapping
    public List<Discursao> getAllDiscussoes() {
        return discursaoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Discursao> getDiscursaoById(@PathVariable Long id) {
        Optional<Discursao> discursao = discursaoService.findById(id);
        return discursao.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Discursao> createDiscursao(@RequestBody Discursao discursao) {
        return ResponseEntity.ok(discursaoService.save(discursao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Discursao> updateDiscursao(@PathVariable Long id, @RequestBody Discursao discursaoDetails) {
        return ResponseEntity.ok(discursaoService.update(id, discursaoDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiscursao(@PathVariable Long id) {
        discursaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
