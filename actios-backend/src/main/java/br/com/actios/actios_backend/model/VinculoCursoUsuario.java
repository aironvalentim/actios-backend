package br.com.actios.actios_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vinculo_curso_usuario")
public class VinculoCursoUsuario {

    @EmbeddedId
    private VinculoCursoUsuarioId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idUsuario")
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idCurso")
    @JoinColumn(name = "id_curso")
    private Curso curso;

    // Construtores
    public VinculoCursoUsuario() {}

    public VinculoCursoUsuario(Usuario usuario, Curso curso) {
        this.usuario = usuario;
        this.curso = curso;
        this.id = new VinculoCursoUsuarioId(usuario.getIdUsuario(), curso.getId());
    }

    // Getters e Setters
    public VinculoCursoUsuarioId getId() {
        return id;
    }

    public void setId(VinculoCursoUsuarioId id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}

