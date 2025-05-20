package br.com.actios.actios_backend.service;

import br.com.actios.actios_backend.model.*;
import br.com.actios.actios_backend.repositorys.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VinculoCursoUsuarioService {

    @Autowired
    private VinculoCursoUsuarioRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public VinculoCursoUsuario vincularUsuarioAoCurso(Integer idUsuario, Integer idCurso) {
        if (repository.existsByUsuarioIdAndCursoId(idUsuario, idCurso)) {
            throw new RuntimeException("Usuário já está vinculado a este curso.");
        }

        Optional<Usuario> usuarioOpt = usuarioRepository.findById(idUsuario);
        Optional<Curso> cursoOpt = cursoRepository.findById(idCurso);

        if (usuarioOpt.isEmpty() || cursoOpt.isEmpty()) {
            throw new RuntimeException("Usuário ou curso não encontrado.");
        }

        VinculoCursoUsuario vinculo = new VinculoCursoUsuario(usuarioOpt.get(), cursoOpt.get());
        return repository.save(vinculo);
    }

    public void desvincularUsuarioDoCurso(Integer idUsuario, Integer idCurso) {
        if (!repository.existsByUsuarioIdAndCursoId(idUsuario, idCurso)) {
            throw new RuntimeException("Vínculo não encontrado.");
        }
        repository.deleteByUsuarioIdAndCursoId(idUsuario, idCurso);
    }

    public List<VinculoCursoUsuario> listarVinculosPorUsuario(Integer idUsuario) {
        return repository.findByUsuarioId(idUsuario);
    }

    public List<VinculoCursoUsuario> listarVinculosPorCurso(Integer idCurso) {
        return repository.findByCursoId(idCurso);
    }
}

