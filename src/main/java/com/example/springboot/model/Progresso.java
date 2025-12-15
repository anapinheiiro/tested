package com.example.springboot.model;


import jakarta.persistence.*;
//import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "progresso")
//@Data
public class Progresso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id", unique = true)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ultima_simulacao_id")
    private Simulacoes ultimaSimulacao;

    @Column(name = "dados_evolucao", columnDefinition = "jsonb")
    private String dadosEvolucao;

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Simulacoes getUltimaSimulacao() {
        return ultimaSimulacao;
    }

    public void setUltimaSimulacao(Simulacoes ultimaSimulacao) {
        this.ultimaSimulacao = ultimaSimulacao;
    }

    public String getDadosEvolucao() {
        return dadosEvolucao;
    }

    public void setDadosEvolucao(String dadosEvolucao) {
        this.dadosEvolucao = dadosEvolucao;
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
