package com.example.springboot.model;

import jakarta.persistence.*;
//import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "respostas")
//@Data
public class Respostas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "simulacao_id")
    private Simulacoes simulacao;

    @ManyToOne
    @JoinColumn(name = "pergunta_id")
    private Perguntas pergunta;

    @Column(name = "url_audio")
    private String urlAudio;

    @Column(name = "url_video")
    private String urlVideo;

    private String transcricao;

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

    public Simulacoes getSimulacao() {
        return simulacao;
    }

    public void setSimulacao(Simulacoes simulacao) {
        this.simulacao = simulacao;
    }

    public Perguntas getPergunta() {
        return pergunta;
    }

    public void setPergunta(Perguntas pergunta) {
        this.pergunta = pergunta;
    }

    public String getUrlAudio() {
        return urlAudio;
    }

    public void setUrlAudio(String urlAudio) {
        this.urlAudio = urlAudio;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public String getTranscricao() {
        return transcricao;
    }

    public void setTranscricao(String transcricao) {
        this.transcricao = transcricao;
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
