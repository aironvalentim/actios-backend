package br.com.actios.actios_backend.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VinculoCursoUsuarioId implements Serializable {

    private Integer idUsuario;
    private Integer idCurso;

    // Construtores
    public VinculoCursoUsuarioId() {}

    public VinculoCursoUsuarioId(Integer idUsuario, Integer idCurso) {
        this.idUsuario = idUsuario;
        this.idCurso = idCurso;
    }

    // Getters e Setters
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    // hashCode e equals (necessário para chave composta)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VinculoCursoUsuarioId)) return false;
        VinculoCursoUsuarioId that = (VinculoCursoUsuarioId) o;
        return Objects.equals(idUsuario, that.idUsuario) &&
                Objects.equals(idCurso, that.idCurso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idCurso);
    }
}

