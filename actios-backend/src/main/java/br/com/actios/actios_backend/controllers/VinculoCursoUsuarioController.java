package br.com.actios.actios_backend.controllers;

import br.com.actios.actios_backend.model.VinculoCursoUsuario;
import br.com.actios.actios_backend.service.VinculoCursoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vinculos")
public class VinculoCursoUsuarioController {

    @Autowired
    private VinculoCursoUsuarioService service;

    @PostMapping("/vincular")
    public VinculoCursoUsuario vincular(@RequestParam Integer idUsuario, @RequestParam Integer idCurso) {
        return service.vincularUsuarioAoCurso(idUsuario, idCurso);
    }

    @DeleteMapping("/desvincular")
    public String desvincular(@RequestParam Integer idUsuario, @RequestParam Integer idCurso) {
        service.desvincularUsuarioDoCurso(idUsuario, idCurso);
        return "Usuário desvinculado do curso com sucesso.";
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<VinculoCursoUsuario> listarPorUsuario(@PathVariable Integer idUsuario) {
        return service.listarVinculosPorUsuario(idUsuario);
    }

    @GetMapping("/curso/{idCurso}")
    public List<VinculoCursoUsuario> listarPorCurso(@PathVariable Integer idCurso) {
        return service.listarVinculosPorCurso(idCurso);
    }
}

