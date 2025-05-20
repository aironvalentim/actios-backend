package br.com.actios.actios_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(name = "area_academica", length = 100)
    private String areaAcademica;

    // Construtores
    public Curso() {}

    public Curso(String nome, String areaAcademica) {
        this.nome = nome;
        this.areaAcademica = areaAcademica;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAreaAcademica() {
        return areaAcademica;
    }

    public void setAreaAcademica(String areaAcademica) {
        this.areaAcademica = areaAcademica;
    }

    // toString para facilitar debug e logs
    @Override
    public String toString() {
        return nome + " (" + areaAcademica + ")";
    }
}

