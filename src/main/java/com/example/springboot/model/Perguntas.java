package com.example.springboot.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "perguntas")
public class Perguntas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texto;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private CargoUsuario cargo;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_dificuldade")
    private NivelDificuldadeEnum nivelDificuldade;

    @Column
    private String categoria;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // --- GETTERS E SETTERS ---

    public Long getId() {
        return id;
    }

    // MÉTODO FALTANTE CORRIGIDO:
    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public CargoUsuario getCargo() {
        return cargo;
    }

    public void setCargo(CargoUsuario cargo) {
        this.cargo = cargo;
    }

    public NivelDificuldadeEnum getNivelDificuldade() {
        return nivelDificuldade;
    }

    public void setNivelDificuldade(NivelDificuldadeEnum nivelDificuldade) {
        this.nivelDificuldade = nivelDificuldade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}