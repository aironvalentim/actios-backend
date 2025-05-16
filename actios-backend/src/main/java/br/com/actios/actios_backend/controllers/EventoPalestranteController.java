package br.com.actios.actios_backend.controllers;

import br.com.actios.actios_backend.model.Evento;
import br.com.actios.actios_backend.service.EventoPalestranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/eventos-palestrantes")
public class EventoPalestranteController {

    @Autowired
    private EventoPalestranteService eventoPalestranteService;

    @GetMapping("/eventos-futuros")
    public Page<Evento> getEventosFuturosPorNomePalestrante(@RequestParam String nome, Pageable pageable) {
        return eventoPalestranteService.buscarEventosFuturosPorNomePalestrante(nome, pageable);
    }

    @PostMapping("/associar")
    public String associarPalestrante(@RequestParam int eventoId, @RequestParam int palestranteId) {
        return eventoPalestranteService.associarPalestranteAoEvento(eventoId, palestranteId);
    }

    @DeleteMapping("/desassociar")
    public String desassociarPalestrante(@RequestParam int eventoId, @RequestParam int palestranteId) {
        return eventoPalestranteService.desassociarPalestranteDoEvento(eventoId, palestranteId);
    }
}
