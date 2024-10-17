package br.com.politics.ONP.controllers;

import br.com.politics.ONP.entities.Discussao;
import br.com.politics.ONP.services.discussao.DiscussaoService;
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

public class DiscussaoController {


    @Autowired
    private DiscussaoService discursaoService;

    @GetMapping
    public List<Discussao> getAllDiscussoes() {
        return discursaoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Discussao> getDiscursaoById(@PathVariable Long id) {
        Optional<Discussao> discursao = discursaoService.findById(id);
        return discursao.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Discussao> createDiscursao(@RequestBody Discussao discursao) {
        return ResponseEntity.ok(discursaoService.save(discursao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Discussao> updateDiscursao(@PathVariable Long id, @RequestBody Discussao discursaoDetails) {
        return ResponseEntity.ok(discursaoService.update(id, discursaoDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiscursao(@PathVariable Long id) {
        discursaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
