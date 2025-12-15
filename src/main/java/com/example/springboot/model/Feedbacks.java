package com.example.springboot.model;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "feedbacks")

public class Feedbacks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "resposta_id", unique = true)
    private Respostas resposta;

    @Column(name = "analise_verbal_nao_verbal", columnDefinition = "jsonb")
    private String analiseVerbalNaoVerbal;

    @Column(name = "feedback_texto_ia")
    private String feedbackTextoIa;

    @Column(name = "pontos_fortes")
    private String pontosFortes;

    @Column(name = "pontos_a_melhorar")
    private String pontosAMelhorar;

    @Column(name = "score_resposta")
    private BigDecimal scoreResposta;

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

    public Respostas getResposta() {
        return resposta;
    }

    public void setResposta(Respostas resposta) {
        this.resposta = resposta;
    }

    public String getAnaliseVerbalNaoVerbal() {
        return analiseVerbalNaoVerbal;
    }

    public void setAnaliseVerbalNaoVerbal(String analiseVerbalNaoVerbal) {
        this.analiseVerbalNaoVerbal = analiseVerbalNaoVerbal;
    }

    public String getFeedbackTextoIa() {
        return feedbackTextoIa;
    }

    public void setFeedbackTextoIa(String feedbackTextoIa) {
        this.feedbackTextoIa = feedbackTextoIa;
    }

    public String getPontosFortes() {
        return pontosFortes;
    }

    public void setPontosFortes(String pontosFortes) {
        this.pontosFortes = pontosFortes;
    }

    public String getPontosAMelhorar() {
        return pontosAMelhorar;
    }

    public void setPontosAMelhorar(String pontosAMelhorar) {
        this.pontosAMelhorar = pontosAMelhorar;
    }

    public BigDecimal getScoreResposta() {
        return scoreResposta;
    }

    public void setScoreResposta(BigDecimal scoreResposta) {
        this.scoreResposta = scoreResposta;
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
