
package com.example.springboot.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "planos")


public class Planos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String nome;

    @Column
    private String descricao;

    @Column(name = "max_simulacoes_por_mes")
    private Integer maxSimulacoesPorMes;

    @Column(name = "permite_ia_avancada")
    private Boolean permiteIaAvancada;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getMaxSimulacoesPorMes() {
        return maxSimulacoesPorMes;
    }

    public void setMaxSimulacoesPorMes(Integer maxSimulacoesPorMes) {
        this.maxSimulacoesPorMes = maxSimulacoesPorMes;
    }

    public Boolean getPermiteIaAvancada() {
        return permiteIaAvancada;
    }

    public void setPermiteIaAvancada(Boolean permiteIaAvancada) {
        this.permiteIaAvancada = permiteIaAvancada;
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
