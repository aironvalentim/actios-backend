package br.com.actios.actios_backend.service;

import br.com.actios.actios_backend.model.Usuario;
import br.com.actios.actios_backend.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrar(Usuario usuario) throws Exception {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new Exception("E-mail já cadastrado.");
        }

        return usuarioRepository.save(usuario);
    }

    public Usuario autenticar(String email, String senha) throws Exception {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmailAndSenha(email, senha);
        return usuarioOpt.orElseThrow(() -> new Exception("Credenciais inválidas."));
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Integer id) throws Exception {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new Exception("Usuário não encontrado."));
    }

    public Usuario atualizar(Usuario usuario) throws Exception {
        if (!usuarioRepository.existsById(usuario.getIdUsuario())) {
            throw new Exception("Usuário não encontrado.");
        }
        return usuarioRepository.save(usuario);
    }

    public void excluir(Integer id) throws Exception {
        if (!usuarioRepository.existsById(id)) {
            throw new Exception("Usuário não encontrado.");
        }
        usuarioRepository.deleteById(id);
    }
}
