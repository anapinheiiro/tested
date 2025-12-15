package com.example.springboot.dto.respostas;

public class RespostaRequestDTO {

    private Integer simulacaoId;
    private Integer perguntaId;
    private String urlAudio;
    private String urlVideo;
    private String transcricao;

    public RespostaRequestDTO() {
    }

    public Integer getSimulacaoId() {
        return simulacaoId;
    }

    public void setSimulacaoId(Integer simulacaoId) {
        this.simulacaoId = simulacaoId;
    }

    public Integer getPerguntaId() {
        return perguntaId;
    }

    public void setPerguntaId(Integer perguntaId) {
        this.perguntaId = perguntaId;
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

}
