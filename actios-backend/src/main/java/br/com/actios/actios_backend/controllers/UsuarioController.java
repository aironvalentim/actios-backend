package br.com.actios.actios_backend.controllers;

import br.com.actios.actios_backend.model.Faculdade;
import br.com.actios.actios_backend.model.Usuario;
import br.com.actios.actios_backend.repositorys.FaculdadeRepository;
import br.com.actios.actios_backend.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private FaculdadeRepository faculdadeRepository;

    // POST: Cadastrar novo usuário
    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        // Associar faculdade se o ID for enviado
        if (usuario.getFaculdade() != null && usuario.getFaculdade().getIdFaculdade() != null) { // Use getIdFaculdade() ao invés de getId()
            Faculdade faculdade = faculdadeRepository.findById(usuario.getFaculdade().getIdFaculdade()).orElse(null);
            usuario.setFaculdade(faculdade);
        }

        // Sempre definir a data atual
        usuario.setDataCadastro(LocalDateTime.now());

        Usuario novoUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(novoUsuario);
    }

    // GET: Listar todos os usuários
    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return ResponseEntity.ok(usuarios);
    }
}
