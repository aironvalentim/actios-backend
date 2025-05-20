package br.com.actios.actios_backend.service;

import br.com.actios.actios_backend.model.Curso;
import br.com.actios.actios_backend.repositorys.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> listarTodos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> buscarPorId(Integer id) {
        return cursoRepository.findById(id);
    }

    public Curso salvar(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso atualizar(Integer id, Curso cursoAtualizado) {
        return cursoRepository.findById(id).map(curso -> {
            curso.setNome(cursoAtualizado.getNome());
            curso.setAreaAcademica(cursoAtualizado.getAreaAcademica());
            return cursoRepository.save(curso);
        }).orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    }

    public void deletar(Integer id) {
        cursoRepository.deleteById(id);
    }
}

