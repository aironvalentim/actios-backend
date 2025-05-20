package br.com.actios.actios_backend.repositorys;

import br.com.actios.actios_backend.model.VinculoCursoUsuario;
import br.com.actios.actios_backend.model.VinculoCursoUsuarioId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VinculoCursoUsuarioRepository extends JpaRepository<VinculoCursoUsuario, VinculoCursoUsuarioId> {

    List<VinculoCursoUsuario> findByUsuarioId(Integer idUsuario);

    List<VinculoCursoUsuario> findByCursoId(Integer idCurso);

    boolean existsByUsuarioIdAndCursoId(Integer idUsuario, Integer idCurso);

    void deleteByUsuarioIdAndCursoId(Integer idUsuario, Integer idCurso);
}

