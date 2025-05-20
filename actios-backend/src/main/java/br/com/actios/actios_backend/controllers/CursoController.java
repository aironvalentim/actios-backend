package br.com.actios.actios_backend.controllers;

import br.com.actios.actios_backend.model.Curso;
import br.com.actios.actios_backend.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin(origins = "*")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> listarTodos() {
        return ResponseEntity.ok(cursoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarPorId(@PathVariable Integer id) {
        return cursoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Curso> criar(@RequestBody Curso curso) {
        return ResponseEntity.ok(cursoService.salvar(curso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizar(@PathVariable Integer id, @RequestBody Curso curso) {
        try {
            return ResponseEntity.ok(cursoService.atualizar(id, curso));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        cursoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

