package br.com.actios.actios_backend.controllers;

import br.com.actios.actios_backend.model.Inscricao;
import br.com.actios.actios_backend.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {

    @Autowired
    private InscricaoService inscricaoService;

    @PostMapping("/inscrever")
    public ResponseEntity<Inscricao> inscrever(
            @RequestParam Integer idUsuario,
            @RequestParam Integer idEvento) throws Exception {
        Inscricao inscricao = inscricaoService.inscrever(idUsuario, idEvento);
        return ResponseEntity.ok(inscricao);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Inscricao>> listarTodas() {
        return ResponseEntity.ok(inscricaoService.listarTodas());
    }

    @DeleteMapping("/cancelar/{id}")
    public ResponseEntity<Void> cancelar(@PathVariable Integer id) throws Exception {
        inscricaoService.cancelarInscricao(id);
        return ResponseEntity.noContent().build();
    }
}
