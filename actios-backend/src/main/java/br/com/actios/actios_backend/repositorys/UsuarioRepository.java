package br.com.actios.actios_backend.repositorys;

import br.com.actios.actios_backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
