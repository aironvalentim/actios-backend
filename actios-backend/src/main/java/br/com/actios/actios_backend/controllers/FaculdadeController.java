package br.com.actios.actios_backend.controllers;


import br.com.actios.actios_backend.model.Faculdade;
import br.com.actios.actios_backend.repositorys.FaculdadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculdades")
public class FaculdadeController {

    @Autowired
    private FaculdadeRepository faculdadeRepository;

    // POST - Cadastrar nova faculdade
    @PostMapping("/cadastrar")
    public Faculdade criarFaculdade(@RequestBody Faculdade faculdade) {
        return faculdadeRepository.save(faculdade);
    }

    // GET - Listar todas as faculdades
    @GetMapping("/listar")
    public List<Faculdade> listarFaculdades() {
        return faculdadeRepository.findAll();
    }
}
